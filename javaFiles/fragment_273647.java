public static void main(String[] args) throws Exception {

    final JFrame frame = new JFrame("Test");

    frame.add(new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;

            System.out.println(g2d.getTransform());
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                 RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
                                 RenderingHints.VALUE_STROKE_PURE);

            double dia = Math.min(getWidth(), getHeight()) - 2;

            for (int i = 0; i < 60 ; i++) {
                double angle = 2 * Math.PI * i / 60;
                g2d.draw(new Line2D.Double(
                        (dia / 2) + Math.cos(angle) * dia / 2.1d,
                        (dia / 2) + Math.sin(angle) * dia / 2.1d,
                        (dia / 2) + Math.cos(angle) * dia / 2.05d,
                        (dia / 2) + Math.sin(angle) * dia / 2.05d));
            }

            g2d.draw(new Ellipse2D.Double(1, 1, dia - 1, dia - 1));
        }
    });

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
    frame.setVisible(true);
}