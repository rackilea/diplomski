import java.awt.GridLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Normal {
    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        JButton button = new JButton("why");
        JPanel panel = new JPanel();
        JTextField field= new JTextField();
        Container c = frame.getContentPane();
        c.setLayout(new GridLayout(3,1));//Devides the container in 3 rows and 1 column
        c.add(panel);//Add in first row
        c.add(button);//Add in second row
        c.add(field);//Add in third row
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        }
}