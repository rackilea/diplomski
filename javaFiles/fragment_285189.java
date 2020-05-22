import java.awt.event.*;
import javax.swing.*;

public class mainClass {
    private static int x, y;
    private static drawing d = new drawing();
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setResizable(false);
        frame.add(d);
        d.addMouseListener(new AL());
    }
    static class AL extends MouseAdapter{
        public void mousePressed(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            d.draw(x,y);
        }
    }
}