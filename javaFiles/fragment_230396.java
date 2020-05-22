import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Side {


    public static void main(String[] args) {

        JFrame frame = new JFrame("JFrame");
        JPanel container = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel1.setBackground(Color.blue);
        panel2.setBackground(Color.red);

        container.setLayout(new GridLayout(0, 2));

        container.add(panel1);
        container.add(panel2);

        frame.getContentPane().add(container, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

    }
}