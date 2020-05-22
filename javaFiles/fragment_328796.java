import javax.swing.*;
import java.net.*;

public class ButtonIcons {

    ButtonIcons() throws MalformedURLException {
        ImageIcon redIcon = new ImageIcon(new URL(
                "https://i.stack.imgur.com/wCF8S.png"));
        ImageIcon grnIcon = new ImageIcon(new URL(
                "https://i.stack.imgur.com/T5uTa.png"));
        JButton button = new JButton("Click me!", grnIcon);
        button.setPressedIcon(redIcon);
        JOptionPane.showMessageDialog(null, button);
    }

    public static void main(String[] args) {
        Runnable r = () -> {
            try {
                ButtonIcons o = new ButtonIcons();
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
            }
        };
        SwingUtilities.invokeLater(r);
    }
}