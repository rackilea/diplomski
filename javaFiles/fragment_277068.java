public static void main(String[] args) {

    JFrame frame = new JFrame("Test");

    frame.add(new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            String text = "Hello World!";

            g.setFont(g.getFont().deriveFont(40f));

            Rectangle2D b = g.getFontMetrics().getStringBounds(text, g);
            Rectangle2D bounds = new Rectangle2D.Double(100 + b.getX(),
                                                        100 + b.getY(),
                                                        b.getWidth(), 
                                                        b.getHeight() / 2);
            g.setClip(bounds);
            g.drawString(text, (int) bounds.getX(), 
                               (int) (bounds.getMaxY() + b.getMaxY()));
        }
    });

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setVisible(true);

}