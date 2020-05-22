import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BtnDisabled {

    public static void main(String[] args) {

        JFrame frame = new JFrame("");
        JLabel label = new JLabel("You and Me");
        label.setVisible(false);
        JPanel panel = new JPanel();
        panel.add(label);

        JButton btn = new JButton("W");
    btn.addActionListener(e -> {
        if (!label.isVisible()) {
            label.setVisible(true);
        }
    });
        panel.add(btn);
        frame.add(panel);
        frame.setSize(new Dimension(500, 500));

        frame.setVisible(true);
    }
}