public class ResizeTextTest extends JFrame{
public ResizeTextTest() {
    add(new MyPanel());
}

public static void main(String[] args) {
    ResizeTextTest t = new ResizeTextTest();
    t.setSize(400,300);
    t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    t.setVisible(true);
}
class MyPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Using a multiplier like this on the width and height of the
        //Panel will give you a text size that correlates with the size
        //of the window.
        Font f = new Font("Arial", Font.PLAIN, 
                (int) (.0005 * this.getWidth() * this.getHeight()));
        g.setFont(f);
        g.drawString("Hello World", 50, 100);

    }
}