import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class TestRadioButton {

    private void initUI() {
        JFrame frame = new JFrame(TestRadioButton.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JRadioButton button = new JRadioButton("Double click me");
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    SwingUtilities.invokeLater(new Runnable() {

                            @Override
                            public void run() {
                                 JOptionPane.showMessageDialog(button, "Radio button has been double clicked");
                            }
                    };
                }
            }
        });

        frame.add(button);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        final TestRadioButton test = new TestRadioButton();
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                test.initUI();
            }
        });
    }
}