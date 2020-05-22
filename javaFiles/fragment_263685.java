public class ImagePane extends JPanel {

    private Image image;

    public ImagePane(Image image) {
        this.image = image;
    }

    @Override
    public Dimension getPreferredSize() {
        return image == null ? new Dimension(0, 0) : new Dimension(image.getWidth(this), image.getHeight(this));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.drawImage(image, 0, 0, this);
        g2d.dispose();
    }
}