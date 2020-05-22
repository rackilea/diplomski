public class VideoPanel extends JPanel {
    private BufferedImage frame;

    public VideoPanel() {

    }

    public void setFrame(BufferedImage image) {
        this.frame = image;
        paintImmediately(getBounds());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(frame == null) return;
        int width = frame.getWidth();
        int height = frame.getHeight();
        Dimension boundary = getSize();
        // Scale image dimensions with aspect ratio to fit inside the panel
        int bwidth;
        int bheight = ((bwidth = boundary.width) * height) / width;
        if (bheight > boundary.height) {
            bwidth = ((bheight = boundary.height) * width) / height;
        }
        // Center it in the space given
        int x = Math.abs(boundary.width - bwidth) / 2;
        int y = Math.abs(boundary.height - bheight) / 2;
        g.drawImage(frame, x, y, bwidth, bheight, null);
    }
}