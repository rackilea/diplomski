import javax.swing.*;
import java.awt.*;

class Demo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JPanel loginJPanel = new JPanel(new BorderLayout());
                JTextField usernameJTextField = new JTextField();
                usernameJTextField.setPreferredSize(new Dimension(50, 100));
                loginJPanel.add(usernameJTextField);

                JFrame frame = new JFrame();
                frame.add(loginJPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.pack();
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
            }
        });
    }
}