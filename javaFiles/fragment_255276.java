import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class TextAreaFun extends JPanel {
    private JTextArea textArea = new JTextArea(20, 40);
    private JTextField textEntry = new JTextField(25);
    private AppendAction appendAction = new AppendAction("Append Text");
    private ProtectAction protectAction = new ProtectAction("Protect Text");
    private ClearAction clearAction = new ClearAction("Clear Text");
    private String protectedText = "";

    public TextAreaFun() {
        textArea.setFocusable(false);
        textArea.setEditable(false);
        JScrollPane taScrollPane = new JScrollPane(textArea);
        taScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        textEntry.setAction(appendAction);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
        bottomPanel.add(textEntry);
        bottomPanel.add(new JButton(appendAction));
        bottomPanel.add(new JButton(protectAction));
        bottomPanel.add(new JButton(clearAction));        

        setLayout(new BorderLayout());
        add(taScrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    private class AppendAction extends AbstractAction {
        public AppendAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
            putValue(SHORT_DESCRIPTION, "Append text to text area");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.append(textEntry.getText() + "\n");
            textEntry.selectAll();
            textEntry.requestFocusInWindow();
        }
    }

    private class ProtectAction extends AbstractAction {
        public ProtectAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
            putValue(SHORT_DESCRIPTION, "Protext text in text area from being cleared");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            protectedText = textArea.getText();
            textEntry.selectAll();
            textEntry.requestFocusInWindow();
        }
    }

    private class ClearAction extends AbstractAction {
        public ClearAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
            putValue(SHORT_DESCRIPTION, "Clear unprotected text from text area");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setText(protectedText);
            textEntry.selectAll();
            textEntry.requestFocusInWindow();
        }
    }

    private static void createAndShowGui() {
        TextAreaFun mainPanel = new TextAreaFun();

        JFrame frame = new JFrame("Text Area Fun");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}