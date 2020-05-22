import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonClass extends JFrame
        implements ActionListener {

    JButton b1 = new JButton("button1");
    JButton b2 = new JButton("button2");
    JButton b3 = new JButton("button3");
    JButton b4 = new JButton("button4");
    JLabel label = new JLabel("buttons:");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ButtonClass();
            }
        });
    }

    public ButtonClass() {
        label.setForeground(Color.WHITE);
        JLabel background = new JLabel(new ImageIcon(getClass().getResource("/resources/space.png")));
        background.setLayout(new BorderLayout());
        setContentPane(background);
        setTitle("Background with buttons");
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        JPanel top = new JPanel();
        top.setOpaque(false);
        top.add(label);
        add(top, BorderLayout.NORTH);
        JPanel bottom = new JPanel();
        bottom.setOpaque(false);
        bottom.add(b1);
        bottom.add(b2);
        bottom.add(b3);
        bottom.add(b4);
        add(bottom, BorderLayout.SOUTH);
        setSize(400, 300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
}