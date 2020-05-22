import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class RespondToEnter extends JPanel {
    private static final int COLS = 40;
    private JTextArea nonEditableTA = new JTextArea(15, COLS);
    private JTextArea editableTA = new JTextArea(5, COLS);
    private EnterAction enterAction = new EnterAction("Submit");
    // private JButton submitButton = new JButton(enterAction);

    public RespondToEnter() {

        // first set up bindings
        int condition = JComponent.WHEN_FOCUSED; // only want this when textarea has focus
        InputMap inputMap = editableTA.getInputMap(condition); // get input and action maps
        ActionMap actionMap = editableTA.getActionMap();
        // bind to the enter key stroke:
        KeyStroke enterStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        String key = enterStroke.toString();  // key to bind input to action
        // bind the enter key stroke to the enter action:
        inputMap.put(enterStroke, key);
        actionMap.put(key, enterAction);

        // allow word wrap
        nonEditableTA.setWrapStyleWord(true);
        nonEditableTA.setLineWrap(true);
        editableTA.setWrapStyleWord(true);
        editableTA.setLineWrap(true);

        nonEditableTA.setFocusable(false); // this is enough to prevent editing
        JScrollPane nonEdScrollPane = new JScrollPane(nonEditableTA);
        nonEdScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JScrollPane edScrollPane = new JScrollPane(editableTA);
        edScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        setLayout(new BorderLayout());
        add(nonEdScrollPane, BorderLayout.CENTER);
        add(edScrollPane, BorderLayout.PAGE_END);       
    }

    // action used in our key bindings
    private class EnterAction extends AbstractAction {
        public EnterAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);  // allow an alt-keystroke mnemonic key
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // get text from editable text area
            String text = editableTA.getText();
            // append to non-editble text area
            nonEditableTA.append(text + "\n");
            editableTA.setText("");  // clear editable
            editableTA.requestFocusInWindow(); // give it focus
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui() {
        RespondToEnter mainPanel = new RespondToEnter();
        JFrame frame = new JFrame("Respond To Enter Key");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}