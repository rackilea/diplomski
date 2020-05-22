public class JImageComponent extends JComponent {

    private static final long serialVersionUID = -6926323540532721196L;

    private final Image image;

    public JImageComponent(Image image) {
        this.image = image;
    }

    public JImageComponent(byte[] data) {
        this(Toolkit.getDefaultToolkit().createImage(data));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics.create();
        int[] pixels = new int[image.getWidth(null)*image.getHeight(null)];
        PixelGrabber pg = 
                new PixelGrabber(image, 0, 0, image.getWidth(null), image.getHeight(null), pixels, 0, image.getWidth(null));
        try {
            pg.grabPixels();
        } catch (InterruptedException e) {
            System.err.println("interrupted waiting for pixels!");
            return;
        }
        if ((pg.getStatus() & ImageObserver.ABORT) != 0) {
            System.err.println("image fetch aborted or errored");
            return;
        }

        for (int i = 0 ; i < image.getWidth(null) ; i++) {
            for (int j = 0 ; j < image.getHeight(null) ; j++) {
                handlesinglepixel(i, j, pixels[j * image.getWidth(null) + i], g2);  
            }
        }
    }

    @Override
    public int getWidth() {
        return image.getWidth(null);
    }

    @Override
    public int getHeight() {
        return image.getHeight(null);
    }

    public void handlesinglepixel(int x, int y, int pixel, Graphics2D g2d) {
        int alpha = (pixel >> 24) & 0xff;
        int red   = (pixel >> 16) & 0xff;
        int green = (pixel >>  8) & 0xff;
        int blue  = (pixel      ) & 0xff;

        Color color = new Color(red,green,blue);
        g2d.setColor(color);
        System.out.println("Alpha value is " + (float)(alpha/255));
        g2d.setComposite(AlphaComposite.SrcAtop.derive((float)(alpha/255)));
        g2d.drawRect(x, y, 1, 1);
    }
}