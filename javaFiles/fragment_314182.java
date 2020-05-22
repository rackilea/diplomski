// Copied and modified from BasicLabelUI
private static class SquishLabelUI extends BasicLabelUI {
    private final Rectangle paintIconR = new Rectangle();
    private final Rectangle paintTextR = new Rectangle();

    private String layout(JLabel label, FontMetrics fm, int width, int height) {
        Insets insets = label.getInsets(null);
        String text   = label.getText();
        Rectangle paintViewR = new Rectangle(insets.left,
                                             insets.top,
                                             width - (insets.left + insets.right),
                                             height - (insets.top + insets.bottom));
        paintIconR.setBounds(0, 0, 0, 0);
        paintTextR.setBounds(0, 0, 0, 0);
        return layoutCL(label, fm, text, null, paintViewR, paintIconR, paintTextR);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        JLabel label = (JLabel)c;

        layout(label, SwingUtilities2.getFontMetrics(label, g), c.getWidth(), c.getHeight());

        View v = (View)c.getClientProperty(BasicHTML.propertyKey);

        Dimension size = getPreferredSize(label);
        BufferedImage img = label.getGraphicsConfiguration()
                                 .createCompatibleImage(size.width, size.height, TRANSLUCENT);

        Graphics2D g2 = img.createGraphics();
        try {
            g2.setColor(label.getBackground());
            g2.setClip(0, 0, size.width, size.height);
            g2.fillRect(0, 0, size.width, size.height);
            v.paint(g2, new Rectangle(0, 0, size.width, size.height));
            int renderWidth = Math.min(size.width, paintTextR.width);
            Image img2 = img.getScaledInstance(renderWidth, paintTextR.height, Image.SCALE_SMOOTH);
            g.drawImage(img2, paintTextR.x, paintTextR.y, null);
        } finally {
            g2.dispose();
        }
    }
}