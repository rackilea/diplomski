public class GamePanel extends JPanel {
    Image[][] images = new Image[size][size];
    // init images

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,/*  Crap! How do we know what location? Look Below */);
    }  
}