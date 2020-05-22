class LocatedImage {
    private Image image;
    private int x, y, width, height;
    private ImageObserver observer;


    public LocatedImage(Image image, int x, int y, int width, 
                                     int height, ImageObserver observer) {
        this.image = image;
        ...
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(image, x, y, width, height, observer);
    }
}