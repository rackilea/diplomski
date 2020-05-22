import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class JOptionNoFocus {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JOptionPane optionPane = new JOptionPane();
            optionPane.setMessage("Fubars Rule!");
            optionPane.setMessageType(JOptionPane.PLAIN_MESSAGE);
            optionPane.setOptionType(JOptionPane.DEFAULT_OPTION);

            KeyStroke enterStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
            optionPane.getInputMap(JComponent.WHEN_FOCUSED).put(enterStroke, enterStroke.toString());
            optionPane.getActionMap().put(enterStroke.toString(), new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // do nothing
                }
            });

            recursiveUnfocusButtons(optionPane);
            JDialog dialog = optionPane.createDialog(null, "Option Title");
            dialog.setVisible(true); 
            System.exit(0);
        });
    }

    private static void recursiveUnfocusButtons(Component component) {
        if (component instanceof JButton) {
            JButton button = (JButton) component;
            button.setFocusable(false);
            return;
        } else if (component instanceof Container) {
            for (Component c : ((Container) component).getComponents()) {
                recursiveUnfocusButtons(c);
            }
        }
    }
}