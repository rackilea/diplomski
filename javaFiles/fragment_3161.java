import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Example extends JPanel {

    public Example() {
         ImageIcon icon = new ImageIcon(this.getClass().getResource(IMAGE1));
         ImageIcon icon1 = new ImageIcon(this.getClass().getResource(IMAGE2));
         ImageIcon icon2 = new ImageIcon(this.getClass().getResource(IMAGE3));
         JLabel label1 = new JLabel(icon); 
         JLabel label2 = new JLabel(icon1); 
         JLabel label3 = new JLabel(icon2); 

         add(label1);
         add(label2);
         add(label3);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.add(new Example());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}