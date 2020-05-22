import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Foo1 extends JPanel {
    private JTextField textField = new JTextField(10);
    private JButton getStatusBtn = new JButton(new GetStatusAction("Get Status"));

    public Foo1() {
        textField.setFocusable(false);
        add(new JLabel("Status:"));
        add(textField);
        add(getStatusBtn);
    }

    private class GetStatusAction extends AbstractAction {
        public GetStatusAction(String name) {
            super(name);
            int mnemonic = name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Component parentComponent = Foo1.this;

            // this panel can hold any gui components that you desire
            // here I simply give it a centered JLabel that displays some text
            JPanel message = new JPanel(new GridBagLayout());
            message.setPreferredSize(new Dimension(200, 100));
            message.add(new JLabel("Some Text"));
            String title = "Get Status";
            int optionType = JOptionPane.OK_CANCEL_OPTION;
            int messageType = JOptionPane.PLAIN_MESSAGE;
            Icon icon = null;
            String[] options = { "Win", "Lose" };
            int initialValue = 0;

            // create and show our JOptionPane, and get the information from it
            int selection = JOptionPane.showOptionDialog(parentComponent,
                    message, title, optionType, messageType, icon, options,
                    initialValue);

            // if the selection chosen was valid (win or lose pushed)
            if (selection >= 0) {
                // get the selection and use it
                textField.setText(options[selection]);
            }
        }
    }

    private static void createAndShowGui() {
        Foo1 mainPanel = new Foo1();

        JFrame frame = new JFrame("Foo1");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}