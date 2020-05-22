public class MyRoundedBorder implements Border {

    protected static final Insets DEFAULT_INSETS = new Insets(4, 4, 4, 4);

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.setColor(Color.WHITE);
        Shape corner = new RoundedShape(width - 8, height - 8);
        g2d.translate(x + 2, y + 2);
        g2d.draw(corner);
        g2d.transform(AffineTransform.getRotateInstance(Math.toRadians(180), (width - 8) / 2, (height - 8) / 2));
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.draw(corner);

        g2d.dispose();

    }

    @Override
    public Insets getBorderInsets(Component c) {

        return DEFAULT_INSETS;

    }

    @Override
    public boolean isBorderOpaque() {

        return true;

    }

    public class RoundedShape extends Path2D.Float {

        public RoundedShape(int width, int height) {

            moveTo(0, height - 20);
            append(new Arc2D.Float(0, height - 20, 20, 20, 180, 45, Arc2D.CHORD), false);
            lineTo(0, 20);
            curveTo(0, 0, 0, 0, 20, 0);
            lineTo(width - 10, 0);
            append(new Arc2D.Float(width - 20, 0, 20, 20, 90, -45, Arc2D.CHORD), false);

        }

    }

}