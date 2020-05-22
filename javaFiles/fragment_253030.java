import java.awt.Container;
import java.awt.Window;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterNew {
    private JDialog dialog = null;
    private JTextField nameField = new JTextField(10);
    private JPasswordField passField = new JPasswordField(10);

    public RegisterNew(Window window, int axis) {
        dialog = new JDialog(window, "Register New", ModalityType.APPLICATION_MODAL);
        Container con = dialog.getContentPane();

        con.setLayout(new BoxLayout(con, axis));

        con.add(new JLabel("Enter your desired username"));
        con.add(nameField);
        con.add(new JLabel("Enter your password"));
        con.add(passField);
        con.add(new JButton(new AcceptAction()));
        dialog.pack();
        dialog.setLocationRelativeTo(window);

    }
    public char[] getPassword() {
        return passField.getPassword();
    }
    public String getUserName() {
        return nameField.getText();
    }
    public void setVisible(boolean b) {
        dialog.setVisible(b);
    }

    private class AcceptAction extends AbstractAction {
        public AcceptAction() {
            super("Accept");
            putValue(MNEMONIC_KEY, KeyEvent.VK_A);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dialog.dispose();
        }
    }

}