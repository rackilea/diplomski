import java.awt.Component;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JDialog dialog = new JDialog();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("My Label");
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(label);

        JScrollPane pane = new JScrollPane(new JTextArea(3, 15));
        pane.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(pane);

        dialog.add(panel);
        dialog.pack();
        dialog.setVisible(true);
    }
}