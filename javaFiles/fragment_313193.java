import java.awt.*;
import javax.swing.*;

public class ColorongPanels {

    private JFrame frame = new JFrame("ColorongPanels");
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();
    private JLabel label1 = new JLabel("Label1");
    private JLabel label2 = new JLabel("Label2");
    private JLabel label3 = new JLabel("Label3");
    private JLabel label4 = new JLabel("Label4");

    public ColorongPanels() {
        frame.setLayout(new GridLayout(2, 2, 5, 5));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel1.setBackground(Color.red);
        panel1.setLayout(new BorderLayout());
        panel1.add(label1, BorderLayout.CENTER);
        panel2.setBackground(Color.yellow);
        panel2.setLayout(new BorderLayout());
        panel2.add(label2, BorderLayout.CENTER);
        panel3.setBackground(Color.black);
        panel3.setLayout(new BorderLayout());
        panel3.add(label3, BorderLayout.CENTER);
        panel4.setBackground(Color.pink);
        panel4.setLayout(new BorderLayout());
        panel4.add(label4, BorderLayout.CENTER);
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ColorongPanels();
            }
        });
    }
}