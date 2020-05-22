import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class TestFrame {

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Test Window");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //frame.setUndecorated(true);
                //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                Box box = Box.createVerticalBox();
                JLabel time = new JLabel("0");
                time.setAlignmentX(Component.CENTER_ALIGNMENT);
                JLabel label = new JLabel("How Long Have I Been Running?");
                label.setAlignmentX(Component.CENTER_ALIGNMENT);
                JButton button = new JButton("EXIT");
                button.setAlignmentX(Component.CENTER_ALIGNMENT);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispatchEvent(new WindowEvent(
                            frame, WindowEvent.WINDOW_CLOSING));
                    }
                });
                box.add(label);
                box.add(time);
                box.add(button);
                frame.add(box, BorderLayout.CENTER);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                long base = System.currentTimeMillis();
                Timer timer = new Timer(100, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        long input = System.currentTimeMillis();
                        time.setText(Long.toString(input - base));
                    }
                });
                timer.start();
            }
        });
    }
}