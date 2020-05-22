public class BackgroundImage extends JPanel{
    private Image image;

    public BackgroundImage (InputStream input) {
        try {
            image = ImageIO.read(input);
            setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2d = (Graphics2D) grphcs;
        g2d.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}