public class OvalImageLabel extends JLabel {

    private Image image;

    public OvalImageLabel(URL imageUrl) throws IOException {
        image = ImageIO.read(imageUrl);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setClip(new java.awt.geom.Ellipse2D.Float(0f,0f, getWidth(),getHeight()/2));
        g.drawImage(image, 0, 0, this);

    }
}