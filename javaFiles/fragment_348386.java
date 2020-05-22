import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
public class ButtonActiveTest extends JPanel {
    private static final int FIELD_COUNT = 5;

    private MyAction myAction = new MyAction("Process Data in Fields"); // The Action
    private JButton myButton = new JButton(myAction);  // the button 
    private JTextField[] textFields = new JTextField[FIELD_COUNT];
    private JMenuBar menuBar = new JMenuBar();


    public ButtonActiveTest() {
        myAction.setEnabled(false); // initially disable button's Action

        // create single Doc listener
        MyDocumentListener myDocumentListener = new MyDocumentListener();
        // create jtext fields in a loop
        for (int i = 0; i < textFields.length; i++) {
            textFields[i] = new JTextField(5); // create each text field

            // add document listener to doc
            textFields[i].getDocument().addDocumentListener(myDocumentListener);

            // add to gui
            add(textFields[i]);
        }
        add(myButton);

        // create menu item with our action
        JMenuItem menuItem = new JMenuItem(myAction);
        JMenu menu = new JMenu("Menu");
        menu.setMnemonic(KeyEvent.VK_M);
        menu.add(menuItem);
        menuBar.add(menu);
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    private static void createAndShowGui() {
        ButtonActiveTest mainPanel = new ButtonActiveTest();

        JFrame frame = new JFrame("ButtonActiveTest");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.setJMenuBar(mainPanel.getMenuBar());
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

    private class MyAction extends AbstractAction {
        public MyAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic); // to give button an alt-key hotkey
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(ButtonActiveTest.this, "Action Performed!");
        }
    }

    private class MyDocumentListener implements DocumentListener {

        @Override
        public void changedUpdate(DocumentEvent e) {
            checkFields();
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            checkFields();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            checkFields();
        }

        // if any changes to any document (any of the above methods called)
        // check if all JTextfields have text. If so, activate the action
        private void checkFields() {
            boolean allFieldsHaveText = true;
            for (JTextField jTextField : textFields) {
                if (jTextField.getText().trim().isEmpty()) {
                    allFieldsHaveText = false;
                }
            }

            myAction.setEnabled(allFieldsHaveText);
        }

    }
}