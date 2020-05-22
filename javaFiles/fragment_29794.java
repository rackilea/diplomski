import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class TestJLabel {

    protected void initUI() {
        JFrame frame = new JFrame(TestJLabel.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel key = new JLabel("Some opaque label with a yellow background.");
        key.setBackground(Color.YELLOW);
        key.setOpaque(true);
        frame.add(key);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestJLabel().initUI();
            }
        });
    }

}