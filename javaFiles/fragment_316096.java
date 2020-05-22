public class Spooky extends Applet {
    Image image;

    public void init() {
        URL url = this.getClass().getResource("spooky.gif");
        image = new ImageIcon(url).getImage();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 0, 0, 300, 300, this);
    }  
}