import java.awt.Graphics;
import javax.swing.JFrame;

public class SwingTest {
    private static class Frame extends JFrame {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            System.out.println(g.getClass().getName());
        }
    }

    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setVisible(true);
    }
}