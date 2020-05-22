import java.awt.*;
import javax.swing.*;

public class ErrorTest extends JFrame {

    public static void main(String[] args) {
        // Creating frame and setting the JLayeredPane as contentpane
        ErrorTest frame = new ErrorTest();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent pane = new JLayeredPane();
        //pane.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));  // Take out FlowLayout
        pane.setPreferredSize(new Dimension(800, 600));
        frame.setContentPane(pane);

        // Creating panels
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.BLUE);
        panel1.setBounds(0, 0, 800, 600);  // <<<---- Set Bounds

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.RED);
        panel2.setBounds(50, 0, 700, 500); // <<---- Set Bounds 

        pane.add(panel1, new Integer(1));
        pane.add(panel2, new Integer(2));

        frame.pack();
        frame.setVisible(true);

    }
}