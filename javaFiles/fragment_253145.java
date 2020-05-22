public class FancyPaintPane extends JPanel {

    private BufferedImage image;

    public FancyPaintPane() {
        try {
            image = ImageIO.read(this.getClass().getResource("/Images/frame.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setOpaque(false);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(image.getWidth(), image.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC)); // SRC_ATOP > Windows
        g2.drawImage(image, 0, 0, this);
        g2.dispose();
    }
}