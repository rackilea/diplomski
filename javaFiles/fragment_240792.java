import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.metal.MetalTextFieldUI;

/**
 * <code>FocusBorder</code>.
 */
public class FocusBorder {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FocusBorder::startUp);
    }

    private static void startUp() {
        UIManager.put("TextFieldUI", ExMetalTextFieldUI.class.getName());
        JPanel mainPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        for (int i = 0; i < 4; i++) {
            mainPanel.add(new JTextField(10));
        }
        JFrame frm = new JFrame();
        frm.add(mainPanel);
        frm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }

    public static class ExMetalTextFieldUI extends MetalTextFieldUI {
        private JTextField field;

        public static ComponentUI createUI(JComponent c) {
            return new ExMetalTextFieldUI();
        }

        @Override
        public void installUI(JComponent c) {
            field = (JTextField) c;
            super.installUI(c);
            updateBorder(false);
            c.addFocusListener(new FocusListener() {

                @Override
                public void focusLost(FocusEvent e) {
                    updateBorder(false);
                }

                @Override
                public void focusGained(FocusEvent e) {
                    updateBorder(true);
                }
            });
        }

        private void updateBorder(boolean gained) {
            if (field.getBorder() instanceof UIResource) {
                Color c = gained ? Color.RED : Color.BLACK;
                field.setBorder(new BorderUIResource(new LineBorder(c)));
            }
        }
    }
}