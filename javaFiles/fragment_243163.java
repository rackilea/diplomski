import javax.swing.JFrame;
import java.awt.Color;

public class Main{

    //Note how we don't need to extend the Rect class (It just adds confusion)
    public static void main(String[] args ) {

        JFrame window = new JFrame("test");
        window.setSize(1000, 800);
        window.setVisible(true);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create Rect
        Rect rect = new Rect();
        //set the size of the new panel
        rect.setPreferredSize(new Dimension(800, 600));
        //add the rect to your JFrame
        window.add(rect);


        //now you can change the color for all Rect instances
        //Note how I use Rect instead of rect, however both will work.
        Rect.myColor = Color.BLUE;
        //And dont forget to update it
        rect.repaint();
    }
}