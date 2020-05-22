import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LayoutManagers extends JPanel{

    public LayoutManagers() {
        JLabel label = new JLabel("Text Field");
        JTextField textField = new JTextField(20);
        JRadioButton rb1 = new JRadioButton("Radio 1");
        JRadioButton rb2 = new JRadioButton("Radio 2");
        JButton button = new JButton("Button");

        JPanel panel1 = new JPanel();
        panel1.add(label);
        panel1.add(textField);

        JPanel panel2 = new JPanel();
        panel2.add(rb1);
        panel2.add(rb2);

        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        panel3.add(button);

        JPanel panel4 = new JPanel(new GridLayout(3, 1));
        panel4.add(panel1);
        panel4.add(panel2);
        panel4.add(panel3);

        setLayout(new GridBagLayout());
        add(panel4);     
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new LayoutManagers());
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
            }
        });
    }
}