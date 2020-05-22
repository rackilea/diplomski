import javax.swing.*;
import java.awt.*;
class example {
    JFrame frame;
    JPanel panel, hPanel1, hPanel2;
    JLabel label1, label2;
    JTextField field1, field2;
    example() {
        frame = new JFrame("example");

        panel = new JPanel();
        hPanel1 = new JPanel();
        hPanel2 = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        hPanel1.setLayout(new FlowLayout());
        hPanel2.setLayout(new FlowLayout());

        label1 = new JLabel("Label 1");
        label2 = new JLabel("Label 2");
        field1 = new JTextField();
        field2 = new JTextField();

        field1.setColumns(6);
        field2.setColumns(6);

        hPanel1.add(label1);
        hPanel1.add(field1);

        hPanel2.add(label2);
        hPanel2.add(field2);

        panel.add(hPanel1);
        panel.add(hPanel2);

        frame.add(panel);

        frame.setSize(400,300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new example();
            }
        });
    }
}