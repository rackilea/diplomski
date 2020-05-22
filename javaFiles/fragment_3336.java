public class BackgroundPanel extends JPanel {
    private BufferedImage backgroundImage;

    public void setBackgroundImage(BufferedImage image) {
        this.backgroundImage = image;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Grpahics2D g2 = (Graphics2D)g;
        if (image != null) {
            g2.drawImage(backgroundImage, 0, 0, this);
        }
    }
}