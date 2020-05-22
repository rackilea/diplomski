import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class TestNoScrolling {

    private int lineCount = 0;
    private LockableViewPort viewport;
    private JTextArea ta;

    private final class LockableViewPort extends JViewport {

        private boolean locked = false;

        @Override
        public void setViewPosition(Point p) {
            if (locked) {
                return;
            }
            super.setViewPosition(p);
        }

        public boolean isLocked() {
            return locked;
        }

        public void setLocked(boolean locked) {
            this.locked = locked;
        }
    }

    protected void initUI() {
        JFrame frame = new JFrame("test");
        ta = new JTextArea(5, 30);
        JScrollPane scrollpane = new JScrollPane();
        viewport = new LockableViewPort();
        viewport.setView(ta);
        scrollpane.setViewport(viewport);
        frame.add(scrollpane);
        frame.pack();
        frame.setVisible(true);
        Timer t = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                viewport.setLocked(true);
                ta.append("Some new line " + lineCount++ + "\n");
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        viewport.setLocked(false);
                    }
                });
            }
        });
        t.setRepeats(true);
        t.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestNoScrolling().initUI();
            }
        });
    }
}