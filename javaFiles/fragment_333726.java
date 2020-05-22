import java.awt.EventQueue;
import java.awt.FontMetrics;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * @see https://stackoverflow.com/a/37801762/230513
 * @see https://stackoverflow.com/a/12532237/230513
 */
public class Evil {

    private static final String S = "Tomorrow's winning lottery numbers: 42, ";
    private final JLabel label = new JLabel(S + "3, 1, 4, 1, 5, 9");

    private void display() {
        JFrame f = new JFrame("Evil");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        FontMetrics fm = label.getFontMetrics(label.getFont());
        int w = SwingUtilities.computeStringWidth(fm, S) + 8;
        int h = fm.getHeight();
        label.setBounds(0, 0, w, h);
        f.add(label);
        f.setSize(w, h * 3);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Evil().display();
            }
        });
    }
}