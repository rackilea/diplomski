import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class SlidingPanel {

    JPanel panel;

    public void makeUI() {
        panel = new JPanel();
        panel.setBackground(Color.RED);
        panel.setBounds(0, 0, 400, 400);

        JButton button = new JButton("Click");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((JButton) e.getSource()).setEnabled(false);
                new Timer(1, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        panel.setLocation(panel.getX() - 1, 0);
                        if (panel.getX() + panel.getWidth() == 0) {
                            ((Timer) e.getSource()).stop();
                            System.out.println("Timer stopped");
                        }
                    }
                }).start();
            }
        });
        panel.add(button);
        JFrame frame = new JFrame("Sliding Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SlidingPanel().makeUI();
            }
        });
    }
}