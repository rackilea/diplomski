import java.awt.Component;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Example {

    public void createAndShowGUI() {
        JButton button = new JButton("Text");
        button.setSize(button.getPreferredSize());

        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(snapshot(button)));

        JPanel contentPane = new JPanel();
        contentPane.add(label);

        JFrame frame = new JFrame();
        frame.setContentPane(contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private BufferedImage snapshot(Component component) {
        BufferedImage image = new BufferedImage(component.getWidth(), component.getHeight(),
                BufferedImage.TYPE_INT_RGB);
        component.paint(image.createGraphics());
        return image;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new Example().createAndShowGUI());
    }
}