import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovingButton {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                buildFrame();
            }
        });
    }

    private static void buildFrame() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(500, 500));
        p.setLayout(null);

        final JLabel label = new JLabel("Starting Text on Label");
        label.setLocation(200, 0);
        label.setSize(label.getPreferredSize());
        p.add(label);

        final JButton b = new JButton("Button");
        b.setSize(b.getPreferredSize());
        b.setLocation(0, 0);
        p.add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b.setLocation((int)b.getLocation().getX() + 20, (int)b.getLocation().getY() + 20);
                label.setText(String.valueOf(System.nanoTime()));
            }
        });


        f.add(p);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}