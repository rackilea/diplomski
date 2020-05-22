public final class PointFactory {

    // private classes
    private class PointImpl implements Point {

        private int x;
        private int y;

        private PointImpl(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x() {
            return x;
        }

        public int y() {
            return y;
        }
    }

    private class PointOrigoImpl implements Point {

        public int x() {
            return 0;
        }

        public int y() {
            return 0;
        }
    }

    // end private classes

    public Point of(int x, int y) {
        if (x == 0 && y == 0) {
            return new PointOrigoImpl();
        }
        return new PointImpl(x, y);
    }

}