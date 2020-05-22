package helpdesk;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Joko Wandiro
 */
public class Layout extends Base {

    JPanel panel_form_edit = new JPanel();
    FlowLayout layout_form_edit_outer = new FlowLayout(FlowLayout.LEFT);
    JPanel panel_form_edit_outer = new JPanel();
    // Form - Edit
    JLabel label_name_update = new JLabel("Name", JLabel.LEFT);
    JTextField input_id_update = new JTextField();
    JTextField input_name_update = new JTextField();
    JButton btn_update = new JButton("Update");

    public Layout() {
        setLookAndFeel();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Main Layout
        GridLayout layout = new GridLayout(5, 1, 10, 10);
        setLayout(layout);
        // Form - Edit
        label_name_update.setPreferredSize(new Dimension(400, 20));
        input_name_update.setPreferredSize(new Dimension(400, 20));
        input_id_update.setVisible(false);
        GridLayout layout_form_edit = new GridLayout(4, 1, 10, 10);
        panel_form_edit.setLayout(layout_form_edit);
        panel_form_edit.add(input_id_update);
        panel_form_edit.add(label_name_update);
        panel_form_edit.add(input_name_update);
        panel_form_edit.add(btn_update);
        panel_form_edit_outer.setLayout(layout_form_edit_outer);
        panel_form_edit_outer.add(panel_form_edit);
        add(panel_form_edit_outer);
        // Set window or jframe scrollable
        Container container = getContentPane();
        JScrollPane scroll = new JScrollPane(container);
        setContentPane(scroll);
        setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Layout app = new Layout();
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            // ignore error
        }
    }

}