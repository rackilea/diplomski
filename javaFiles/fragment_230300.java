class ImagePanel extends JPanel {
    private Image image;
    int x, y;
    public ImagePanel(Image image, int x, int y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, x, y, null);
    }
}