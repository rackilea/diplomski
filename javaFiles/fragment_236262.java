public class ImageInPanel extends JPanel {
    private BufferedImage image;
    private int x;
    private int y;    
    public void paint(Graphics g) {
        g.drawImage(image, x, y, this);
    }
    // getters and setters
}