public class TextPanel extends JPanel{
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString("Hello, Stackoverflow!", xLocation, yLocation);
    }
}