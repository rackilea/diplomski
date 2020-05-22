import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 * <code>ComboTest</code>.
 */
public class ComboTest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new ComboTest()::startUp);
    }

    private void startUp() {
        JComboBox<String> combo = new JComboBox<>(new String[] {"A", "B", "C"});
        combo.setFont(new Font("Serif", Font.BOLD, 30));
        combo.setRenderer(new ComboRenderer());
        JFrame frm = new JFrame("Combo test");
        frm.add(combo);
        frm.pack();
        frm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }

    private static class ComboRenderer extends BasicComboBoxRenderer {

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 80);
        }
    }
}