public class BackgroundPane extends JPanel {

    private BufferedImage img;

    public BackgroundPane(BufferedImage img) {
        this.img = img;
    }

    @Override
    public Dimension getPreferredSize() {
        return img == null ? super.getPreferredSize() : new Dimension(img.getWidth(), img.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }
}