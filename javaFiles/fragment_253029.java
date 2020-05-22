import java.awt.BorderLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class TestRegistration extends JPanel {
    private JTextArea textArea = new JTextArea(30, 60);

    public TestRegistration() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JButton(new ShowRegisterNewAction()));
        textArea.setFocusable(false);
        textArea.setEditable(false);

        setLayout(new BorderLayout());
        add(new JScrollPane(textArea, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    private class ShowRegisterNewAction extends AbstractAction {
        private RegisterNew registerNew = null;

        public ShowRegisterNewAction() {
            super("Show Register New Dialog");
            putValue(MNEMONIC_KEY, KeyEvent.VK_S);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (registerNew == null) {
                JButton btn = (JButton) e.getSource();
                Window window = SwingUtilities.getWindowAncestor(btn);
                registerNew = new RegisterNew(window, BoxLayout.PAGE_AXIS);
            }
            registerNew.setVisible(true);
            String userName = registerNew.getUserName();
            String password = new String(registerNew.getPassword());

            textArea.append("User Name: " + userName + "\n");
            textArea.append("Password: " + password + "\n");
            textArea.append("\n");
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("TestRegistration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TestRegistration());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}