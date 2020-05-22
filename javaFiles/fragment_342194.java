import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class CompoundBorderDemo {

    public CompoundBorderDemo() {
        JFrame frame = new JFrame();
        JPanel panel = createPanel();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 5, 10, 10));
        EmptyBorder panelBorder = new EmptyBorder(10, 10, 10, 10);
        panel.setBorder(panelBorder);
        EmptyBorder border = new EmptyBorder(5, 20, 5, 20);
        LineBorder line = new LineBorder(Color.blue, 2, true);
        CompoundBorder compound = new CompoundBorder(line, border);
        for (int i = 0; i < 25; i++) {
            JLabel label = new JLabel("Label" + i);
            label.setBorder(compound);
            panel.add(label);
        }
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CompoundBorderDemo();
            }
        });
    }
}