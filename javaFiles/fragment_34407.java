private BufferedImage image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
private Graphics2D imageGraphics = image.createGraphics();

public class ml extends MouseAdapter implements MouseMotionListener, MouseListener {

    public void mousePressed(MouseEvent e) {
        end = e.getPoint();
    }

    public void mouseDragged(MouseEvent e) {
        start = end;
        end = e.getPoint();

        imageGraphics.setColor(c);
        imageGraphics.setStroke(new BasicStroke(5));
        imageGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        imageGraphics.drawLine(start.x, start.y, end.x, end.y);

        repaint();
    }

    public void mouseReleased(MouseEvent e) {
        start = null;
        end = null;
    }
}

public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.drawImage(image, null, 0, 0);
}