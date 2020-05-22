public class Test {

    public static void main(final String[] args) {
        new Test().doStuff();
    }

    private void doStuff() {
        long start;
        long end;
        MouseTracker tracker = new MouseTracker();
        while (true) {
            start = System.nanoTime();
            Point point = tracker.getLocation();
            end = System.nanoTime();
            System.out.println("Time taken: " + (end - start));
        }
    }

    class MouseTracker extends MouseMotionAdapter {

        private Point location;

        @Override
        public void mouseMoved(final MouseEvent e) {
            location = e.getLocationOnScreen();
        }

        public Point getLocation() {
            return location;
        }

    }

}