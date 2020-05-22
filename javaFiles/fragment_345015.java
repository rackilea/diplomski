class BetterEllipse extends Ellipse2D.Double {
    private int segments;

    public BetterEllipse(int segments, double x, double y, double w, double h) {
        super(x, y, w, h);
        this.segments = segments;
    }

    public int getSegments() {
        return segments;
    }

    @Override
    public PathIterator getPathIterator(final AffineTransform affine) {
        return new PathIterator() {
            private int index = 0;

            @Override
            public void next() {
                index++;
            }

            @Override
            public int getWindingRule() {
                return WIND_NON_ZERO;
            }

            @Override
            public boolean isDone() {
                return index > getSegments() + 1;
            }

            @Override
            public int currentSegment(double[] coords) {
                int count = getSegments();
                if (index > count)
                    return SEG_CLOSE;
                BetterEllipse ellipse = BetterEllipse.this;
                double x = ellipse.getCenterX() + Math.sin(2 * Math.PI * index / count) * ellipse.getWidth() / 2;
                double y = ellipse.getCenterY() + Math.cos(2 * Math.PI * index / count) * ellipse.getHeight() / 2;
                if (index == 0) {
                    coords[0] = x;
                    coords[1] = y;
                    if (affine != null)
                        affine.transform(coords, 0, coords, 0, 1);
                    return SEG_MOVETO;
                }
                double x0 = ellipse.getCenterX() + Math.sin(2 * Math.PI * (index - 2) / count) * ellipse.getWidth() / 2;
                double y0 = ellipse.getCenterY() + Math.cos(2 * Math.PI * (index - 2) / count) * ellipse.getHeight() / 2;
                double x1 = ellipse.getCenterX() + Math.sin(2 * Math.PI * (index - 1) / count) * ellipse.getWidth() / 2;
                double y1 = ellipse.getCenterY() + Math.cos(2 * Math.PI * (index - 1) / count) * ellipse.getHeight() / 2;
                double x2 = x;
                double y2 = y;
                double x3 = ellipse.getCenterX() + Math.sin(2 * Math.PI * (index + 1) / count) * ellipse.getWidth() / 2;
                double y3 = ellipse.getCenterY() + Math.cos(2 * Math.PI * (index + 1) / count) * ellipse.getHeight() / 2;
                double x1ctrl = x1 + (x2 - x0) / 6;
                double y1ctrl = y1 + (y2 - y0) / 6;
                double x2ctrl = x2 + (x1 - x3) / 6;
                double y2ctrl = y2 + (y1 - y3) / 6;
                coords[0] = x1ctrl;
                coords[1] = y1ctrl;
                coords[2] = x2ctrl;
                coords[3] = y2ctrl;
                coords[4] = x2;
                coords[5] = y2;
                if (affine != null)
                    affine.transform(coords, 0, coords, 0, 3);
                return SEG_CUBICTO;
            }

            @Override
            public int currentSegment(float[] coords) {
                double[] temp = new double[6];
                int ret = currentSegment(temp);
                for (int i = 0; i < coords.length; i++)
                    coords[i] = (float)temp[i];
                return ret;
            }
        };
    }
}