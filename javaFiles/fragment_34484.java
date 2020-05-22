import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.WindowConstants;
import javax.swing.plaf.basic.ComboPopup;

/**
 * <code>JComboText</code>.
 */
public class JComboText {

    public static void main(String[] args) {
        String[] items = new String[] {"First", "Second", "Third", "Fourth"};
        JComboBox<String> combo = new JComboBox<>(items);
        combo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean byUser = isTriggeredByUser(combo);
                System.out.println("Changed by: " + (byUser ? "user" : "program"));
            }
        });
        JButton button = new JButton("Clear selection");
        button.addActionListener(e -> combo.setSelectedItem(null));
        JFrame frm = new JFrame("Combo test");
        frm.setLayout(new FlowLayout());
        frm.add(combo);
        frm.add(button);
        frm.pack();
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }

    private static boolean isTriggeredByUser(JComboBox<?> combo) {
        // check whether the change was triggered by another component
        final ComboPopup popup = (ComboPopup) combo.getUI().getAccessibleChild(combo, 0);
        final JList<?> list = popup.getList();
        if (EventQueue.getCurrentEvent() instanceof InputEvent) {
            return Objects.equals(EventQueue.getCurrentEvent().getSource(), combo)
                    || Objects.equals(EventQueue.getCurrentEvent().getSource(), list);
        }
        return false;
    }
}