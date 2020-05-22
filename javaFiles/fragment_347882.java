public class ImageFrame extends JFrame {
    BufferedImage image;

    public ImageFrame(final BufferedImage image) {
        this(image, "No Title");
    }

    public ImageFrame(final BufferedImage image, final String title) {
        this.image = image;
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                if (image != null) {
                    setSize(image.getWidth(null), image.getHeight(null));
                } else {
                    setSize(250, 90);
                }
                setTitle(title);
                setVisible(true);
                repaint();
            }
        });
    }

    public void paint(Graphics g) {
        if (image == null) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 250, 90);
            System.out.println("image null");
            g.setFont(new Font("Arial", Font.BOLD, 24));
            g.setColor(Color.RED);
            g.drawString("Invalid or No Image", 10, 50);
        } else {
            g.drawImage(image, 0, 0, null);
        }
    }
}