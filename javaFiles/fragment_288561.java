public class GamePanel extends JPanel {
    List<LocatedImage> imagesToDraw;
    // init images
    // e.g. imagesToDraw.add(new LocatedImage(img, 20, 20, 100, 100, this));

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g.create();
        for (LocatedImage image: imagesToDraw) {
            image.draw(g2d);
        }
        g2d.dispose();
    }  
}