import java.awt.*;
import javax.swing.*;

public class TestImageCenter {

    public static void main(String[] args) {
        ImageIcon icon = new ImageIcon(TestImageCenter.class.getResource("/resources/images/ooooo.png"));
        JLabel iconLabel = new JLabel(icon);
        JPanel iconPanel = new JPanel(new GridBagLayout());
        iconPanel.add(iconLabel);

        JPanel textPanel= new JPanel(new GridLayout(0, 1));
        for (int i = 0; i < 15; i++) {
            textPanel.add(new JLabel("Hello, StackOverfkow"));
        }

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(textPanel);
        mainPanel.add(iconPanel, BorderLayout.WEST);
        JOptionPane.showMessageDialog(null, mainPanel, "Center Image Dialog", JOptionPane.PLAIN_MESSAGE);
    }
}