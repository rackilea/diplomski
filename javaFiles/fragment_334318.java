public class ImagePanel extends JPanel {
    private Image image;

    public ImagePanel(Image image) {
        this.image = image;
        // setSize(image.getWidth(null), image.getHeight(null));
    }

    @Override
    public Dimension getPreferredSize() {
        if (image != null) {
            int w = image.getWidth();
            int h = image.getHeight();
            return new Dimension(w, h);
        } else {
            return super.getPreferredSize();
        }
    }

    @Override   // this should be protected, not public
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, null);
        }
    }
}