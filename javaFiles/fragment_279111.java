public class RectangleAnnotation extends JPanel {

    private BufferedImage img;
    private ArrayList<DrawableAnnotation> annotations

    // Constructor for this class.
    public RectangleAnnotation(BufferedImage img) {
        this.img = img;
        annotations = new ArrayList<DrawableAnnotation>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img, 0, 0, this);
        for (DrawableAnnotation d : annotations) {
            d.paint(g2d);
        }
    }

    public void addAnnotation(DrawableAnnotation a) {
        annotations.add(a);
    }
}