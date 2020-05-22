import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ColorChooserDemo extends JPanel {

    JLabel label;
    JButton button1, button2;

    public ColorChooserDemo() {
        this.setBackground(new Color(255, 0, 255));
        setLayout(new GridBagLayout());

        label = new JLabel("This is Text");
        button1 = new JButton("Set Word Color");
        button2 = new JButton("Set Background Color");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        add(label, gbc);
        add(button1, gbc);
        add(button2, gbc);

        button1.addActionListener(buttonPressed);
        button2.addActionListener(buttonPressed);
        button1.setActionCommand("words");
        button2.setActionCommand("back");

        label.setFont(new Font("Helvetica", Font.BOLD, 20));
        button1.setFont(new Font("Helvetica", Font.BOLD, 20));
        button2.setFont(new Font("Helvetica", Font.BOLD, 20));
    }

    AbstractAction buttonPressed = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("words")) {
                Color c = JColorChooser.showDialog(null, "Choose a Color", label.getForeground());
                if (c != null) {
                    label.setForeground(c);
                }
            }
            if (e.getActionCommand().equals("back")) {
                System.out.println("...");
                Color c = JColorChooser.showDialog(null, "Choose a Color", getBackground());
                if (c != null) {
                    setBackground(c);
                }
            }
            repaint();
        }
    };

    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        JFrame frame = new JFrame("ColorChooserDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ColorChooserDemo());
        frame.setSize(400, 200);
        frame.setLocation((int) (screenSize.getWidth() - 400) / 2, (int) (screenSize.getHeight() - 200) / 2);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}