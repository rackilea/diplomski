package stackoverflow;

import javax.swing.*;

public class TestIMage {

    public TestIMage() {
        ImageIcon icon = new ImageIcon(TestIMage.class.getResource("/res/stackoverflow5.png"));
        JLabel label = new JLabel(icon);

        JFrame frame = new JFrame();
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TestIMage();
            }
        });
    }
}