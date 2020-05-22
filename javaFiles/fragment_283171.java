import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Test {

/**
 * @param args
 */
public static void main(String[] args) {
    JFrame jmb = new JFrame();
    ImageButton ib = new ImageButton(new ImageIcon("res/buttonImage.png"));
    ib.setMinimumDetectionAlpha(0);
    ib.addMouseListener(new MouseListener(){

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("eventFired");       

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            System.out.println("eventFired");       

        }

        @Override
        public void mouseExited(MouseEvent e) {
            System.out.println("eventFired");       

        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("eventFired");       

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("eventFired");       

        }

    });
    jmb.add(ib);
    jmb.pack();
    jmb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jmb.show();
}

}