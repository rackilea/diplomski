import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.RepaintManager;
import javax.swing.SwingUtilities;

/** @see https://stackoverflow.com/questions/7787998 */
public class EDTViolation {

    public static void main(String args[]) {
        RepaintManager.setCurrentManager(new CheckThreadViolationRepaintManager());
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    private static class CheckThreadViolationRepaintManager extends RepaintManager {
    //http://weblogs.java.net/blog/alexfromsun/archive/2006/02/debugging_swing.html

        private boolean completeCheck = true;
        private WeakReference<JComponent> lastComponent;

        public CheckThreadViolationRepaintManager(boolean completeCheck) {
            this.completeCheck = completeCheck;
        }

        public CheckThreadViolationRepaintManager() {
            this(true);
        }

        public boolean isCompleteCheck() {
            return completeCheck;
        }

        public void setCompleteCheck(boolean completeCheck) {
            this.completeCheck = completeCheck;
        }

        @Override
        public synchronized void addInvalidComponent(JComponent component) {
            checkThreadViolations(component);
            super.addInvalidComponent(component);
        }

        @Override
        public void addDirtyRegion(JComponent component, int x, int y, int w, int h) {
            checkThreadViolations(component);
            super.addDirtyRegion(component, x, y, w, h);
        }

        private void checkThreadViolations(JComponent c) {
            if (!SwingUtilities.isEventDispatchThread() && (completeCheck || c.isShowing())) {
                boolean repaint = false;
                boolean fromSwing = false;
                boolean imageUpdate = false;
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                for (StackTraceElement st : stackTrace) {
                    if (repaint && st.getClassName().startsWith("javax.swing.")
                        && // for details see 
                        // https://swinghelper.dev.java.net/issues/show_bug.cgi?id=1
                        !st.getClassName().startsWith("javax.swing.SwingWorker")) {
                        fromSwing = true;
                    }
                    if (repaint && "imageUpdate".equals(st.getMethodName())) {
                        imageUpdate = true;
                    }
                    if ("repaint".equals(st.getMethodName())) {
                        repaint = true;
                        fromSwing = false;
                    }
                    if ("read".equals(st.getMethodName()) && "javax.swing.JEditorPane".equals(st.getClassName())) {
                        // Swing reads html from a background thread
                        return;
                    }
                }
                if (imageUpdate) {
                //assuming it is java.awt.image.ImageObserver.imageUpdate(...) 
                    //image was asynchronously updated, that's ok 
                    return;
                }
                if (repaint && !fromSwing) {
                    //no problems here, since repaint() is thread safe
                    return;
                }
                //ignore the last processed component
                if (lastComponent != null && c == lastComponent.get()) {
                    return;
                }
                lastComponent = new WeakReference<JComponent>(c);
                violationFound(c, stackTrace);
            }
        }

        protected void violationFound(JComponent c, StackTraceElement[] stackTrace) {
            System.out.println();
            System.out.println("EDT violation detected");
            System.out.println(c);
            for (StackTraceElement st : stackTrace) {
                System.out.println("\tat " + st);
            }
        }
    }
}