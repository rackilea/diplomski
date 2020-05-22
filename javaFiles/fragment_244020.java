import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class KeyBindingEg extends JPanel {
    private static final int LARGE_TA_ROWS = 20;
    private static final int TA_COLS = 40;
    private static final int SMALL_TA_ROWS = 3;
    private JTextArea largeTextArea = new JTextArea(LARGE_TA_ROWS, TA_COLS);
    private JTextArea smallTextArea = new JTextArea(SMALL_TA_ROWS, TA_COLS);
    private Action submitAction = new SubmitAction("Submit", KeyEvent.VK_S);
    private JButton submitButton = new JButton(submitAction);

    public KeyBindingEg() {
        // set up key bindings
        int condition = JComponent.WHEN_FOCUSED; // only bind when the text area is focused
        InputMap inputMap = smallTextArea.getInputMap(condition);
        ActionMap actionMap = smallTextArea.getActionMap();
        KeyStroke enterStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        inputMap.put(enterStroke, enterStroke.toString());
        actionMap.put(enterStroke.toString(), submitAction);

        // set up GUI            
        largeTextArea.setFocusable(false); // this is for display only
        largeTextArea.setWrapStyleWord(true);
        largeTextArea.setLineWrap(true);
        smallTextArea.setWrapStyleWord(true);
        smallTextArea.setLineWrap(true);
        JScrollPane largeScrollPane = new JScrollPane(largeTextArea);
        JScrollPane smallScrollPane = new JScrollPane(smallTextArea);
        largeScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        smallScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(smallScrollPane, BorderLayout.CENTER);
        bottomPanel.add(submitButton, BorderLayout.LINE_END);

        setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        setLayout(new BorderLayout(3, 3));
        add(largeScrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    private class SubmitAction extends AbstractAction {
        public SubmitAction(String name, int mnemonic) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = smallTextArea.getText();
            smallTextArea.selectAll(); // keep text, but make it easy to replace
            // smallTextArea.setText(""); // or if you want to clear the text
            smallTextArea.requestFocusInWindow();

            // TODO: send text to chat server here

            // record text in our large text area
            largeTextArea.append("Me> ");
            largeTextArea.append(text);
            largeTextArea.append("\n");
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Key Binding Eg");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new KeyBindingEg());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}