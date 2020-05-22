import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

@SuppressWarnings("unchecked")
public class ComboBgTest {

    private static final String[] VALUES = {"One", "Two", "Three"};
    @SuppressWarnings("serial")
    public static void main(String[] args) {
        JComboBox<String> cb = new JComboBox<>(VALUES);
        cb.setSelectedItem(null);
        cb.setRenderer(new BasicComboBoxRenderer() {
            boolean ignoreBG = true;
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
                    boolean cellHasFocus) {
                ignoreBG = false;
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (index == -1) { // check whether we are render the item shown at top
                    if (VALUES[0].equals(value)) {
                        c.setBackground(Color.RED);
                    } else if (VALUES[1].equals(value)) {
                        setBackground(Color.GREEN);
                    } else if (VALUES[2].equals(value)) {
                        setBackground(Color.BLUE);
                    }
                }
                ignoreBG = true;
                return this;
            }

            @Override
            public void setBackground(Color bg) {
                // ignore all BG which is set from outside.
                if (!ignoreBG) {
                    super.setBackground(bg);
                }
            }
        });
        JFrame frm = new JFrame("Combo test");
        frm.add(cb);
        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}