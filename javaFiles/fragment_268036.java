import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class AreaFrame3 {

    protected void initUI() {
        // Create array containing shapes
        String[] shapes = { "(no shape selected)", "Circle", "Equilateral  Triangle", "Square" };
        // Use combobox to create drop down menu
        JComboBox comboBox = new JComboBox(shapes);
        JLabel label1 = new JLabel("Select shape:");
        JPanel panel1 = new JPanel(new FlowLayout()); // set frame layout
        JLabel label2 = new JLabel("Text label:");
        JTextField text = new JTextField(10); // create text field
        panel1.add(label1);
        panel1.add(comboBox);
        panel1.add(label2);
        panel1.add(text);
        JFrame frame = new JFrame("Area Calculator Window");// create a JFrame to put combobox
        frame.setLayout(new FlowLayout()); // set layout
        frame.add(panel1);
        JButton button = new JButton("GO"); // create GO button
        frame.add(button);
        // set default close operation for JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // make JFrame visible. So we can see it
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AreaFrame3().initUI();
            }
        });
    }
}