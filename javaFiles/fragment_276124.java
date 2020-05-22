import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class ButtonWithImageAndText {
    private JFrame frame;
    private JButton button;
    private Icon icon;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ButtonWithImageAndText().createAndShowGui());
    }

    private void createAndShowGui() {
        frame = new JFrame(getClass().getSimpleName());
        try {
            icon = new ImageIcon(ImageIO.read(getClass().getResource("up.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        button = new JButton();

        button.setIcon(icon);

        button.setText("Click me!");
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setFont(new Font("Arial", Font.PLAIN, 40));
        button.setForeground(Color.RED);

        frame.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}