import java.awt.*;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.Border;

public class BackgroundImage {

    private static final String IMG = "http://i.stack.imgur.com/JEoYs.jpg";

    private void init() throws Exception {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel background = new JLabel(new ImageIcon(new URL(IMG)));
        background.setLayout(new GridBagLayout());
        background.add(loginPanel());
        f.setContentPane(background);

        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private JPanel loginPanel() {
        Border whiteLine = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        JPanel pLogin = new JPanel(new GridBagLayout());
        pLogin.setBackground(Color.cyan);
        pLogin.setPreferredSize(new Dimension(400, 250));
        pLogin.setBorder(whiteLine);
        return pLogin;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new BackgroundImage().init();
            } catch (Exception ex) {}
        });
    }
}