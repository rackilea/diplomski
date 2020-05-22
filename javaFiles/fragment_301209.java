public class ImageView extends JComponent
        implements ComponentListener {
    private static final long serialVersionUID = 3761966077344495154L;

    private BufferedImage image;
    private int imageX;
    private int imageY;
    private int imageWidth;
    private int imageHeight;

    /** Creates a new instance of ImageView */
    public ImageView() {
        addComponentListener(this);
    }


    public BufferedImage getImage() {
        return image;
    }

    public Rectangle getImageBounds() {
        if (image == null) {
            return null;
        } else {
            return new Rectangle(imageX, imageY, imageWidth, imageHeight);
        }
    }

    public void setImage(final BufferedImage newValue) {
        image = newValue;
        computeBounds();
        repaint();
    }


    @Override
    public void paint(Graphics g) {
        long tm = System.currentTimeMillis();
        if (isOpaque()) {
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
        }

        BufferedImage img = image;
        if (img != null) {
            g.drawImage(img, imageX, imageY, imageWidth, imageHeight, null);
        }
        tm = System.currentTimeMillis()-tm;
    }

    public void componentResized(ComponentEvent e) {
        computeBounds();
    }

    public void componentMoved(ComponentEvent e) {
    }

    public void componentShown(ComponentEvent e) {
        computeBounds();
    }

    public void componentHidden(ComponentEvent e) {
    }

    private void computeBounds() {
        BufferedImage img = image;
        if (img != null) {
            int width = this.getWidth();
            int height = this.getHeight();
            int wi = img.getWidth();
            int hi = img.getHeight();
            imageWidth = width;
            imageHeight = height;
            imageX = 0;
            imageY = 0;
            if (wi*height < hi*width) {
                imageWidth = wi*height/hi;
                imageX = (width-imageWidth)/2;
            } else {
                imageHeight = hi*width/wi;
                imageY = (height-imageHeight)/2;
            }
        }
    }