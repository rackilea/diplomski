import java.awt.*;
import javax.swing.*;

public class TestJLabelIcon {

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setLayout(new GridLayout(0, 1));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(createPanel("abc"));
                frame.add(createPanel("defghij"));
                frame.add(createPanel("klmn"));
                frame.add(createPanel("opq"));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

            private JPanel createPanel(String s) {
                JPanel p = new JPanel(new BorderLayout());
                p.add(new JLabel(s, JLabel.LEFT), BorderLayout.WEST);
                Icon icon = UIManager.getIcon("FileChooser.detailsViewIcon");
                p.add(new JLabel(icon, JLabel.RIGHT), BorderLayout.EAST);
                p.setBorder(BorderFactory.createLineBorder(Color.blue));
                return p;
            }
        });
    }
}