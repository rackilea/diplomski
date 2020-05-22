public static void main(String[] args) {
    JFrame f = new JFrame();
    f.setSize(new Dimension(600, 400));
    f.getContentPane().setLayout(null);
    RoundPanel rp = new RoundPanel();
    rp.setBounds(100, 50, 400, 300);
    f.getContentPane().add(rp);
    f.setVisible(true);
}

static class RoundPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        // Prepare a red rectangle
        BufferedImage bi = new BufferedImage(400, 300, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gb = bi.createGraphics();
        gb.setPaint(Color.RED);
        gb.fillRect(0, 0, 400, 300);
        gb.dispose();

        // Set a rounded clipping region:
        RoundRectangle2D r = new RoundRectangle2D.Float(0, 0, 400, 300, 20, 20);
        g.setClip(r);

        // Draw the rectangle (and see whether it has round corners)
        g.drawImage(bi, 0, 0, null);
    }
}