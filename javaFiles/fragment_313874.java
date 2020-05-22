class ImagePanel extends JPanel {
    private BufferedImage image;

    public ImagePanel() {

    }

    public ImagePanel(String filename) {
        // image = new ImageIcon(filename).getImage();
        // don't get images this way.
        // use ImageIO.read(URL url) and get the image as a resource
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (image == null) {
            return super.getPreferredSize();
        } else {
            int w = image.getWidth();
            int h = image.getHeight();
            return new Dimension(w, h);
        }
    }
}