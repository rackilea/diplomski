import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Rect extends JPanel{
    public static Color myColor = Color.RED;
    public static int myX = 10;
    public static int myY = 10;
    public static int myWidth = 200;
    public static int myHeight = 200;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(myColor);
        g.fillRect(myX, myY, myWidth, myHeight); 
    }
}