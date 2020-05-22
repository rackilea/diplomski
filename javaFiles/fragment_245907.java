import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class LayoutExample extends JPanel {
    private static final int MV_ROWS = 65;
    private static final int MV_COLS = 100;
    private static final int TA_ROWS = 34;
    private static final int TA_COLS = 54;
    private static final int ITA_ROWS = 8;
    private static final Font MV_FONT = new Font("Consolas", 0, 8);
    private static final Font TA_FONT = new Font("Consolas", 0, 12);

    private JTextArea mapView = new JTextArea(MV_ROWS, MV_COLS);
    private JTextArea textArea = new JTextArea("Static Text\n", TA_ROWS, TA_COLS);
    private JTextArea inputTextArea = new JTextArea(ITA_ROWS, TA_COLS);

    public LayoutExample() {
        mapView.setFont(MV_FONT);
        mapView.setEditable(false);
        mapView.setFocusable(false);
        JScrollPane mvScrollPane = new JScrollPane(mapView);

        textArea.setFont(TA_FONT);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setFocusable(false);
        JScrollPane taScrollPane = new JScrollPane(textArea);
        taScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        setEnterKeyBindings(inputTextArea);
        inputTextArea.setFont(TA_FONT);
        inputTextArea.setLineWrap(true);
        inputTextArea.setWrapStyleWord(true);
        JScrollPane itaScrollPane = new JScrollPane(inputTextArea);
        itaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(taScrollPane, BorderLayout.CENTER);
        rightPanel.add(itaScrollPane, BorderLayout.PAGE_END);

        setLayout(new GridLayout(1, 0));
        add(mvScrollPane);
        add(rightPanel);

        inputTextArea.setText(">");
    }

    // to capture the "enter" key being pressed without having to use a
    // KeyListener
    private void setEnterKeyBindings(final JTextArea textComponent) {
        // only accept input when this component is focused
        int condition = WHEN_FOCUSED; 
        InputMap inputMap = textComponent.getInputMap(condition);
        ActionMap actionMap = textComponent.getActionMap();

        // only will bind one keystroke -- that for enter key
        KeyStroke enterKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        inputMap.put(enterKeyStroke, enterKeyStroke.toString());

        // action to take if enter is pressed
        actionMap.put(enterKeyStroke.toString(), new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // get text from input text area, and then clear text
                String text = textComponent.getText();
                textComponent.setText(">");

                // append this text to the upper text area
                textArea.append(text + "\n");

                // TODO: send text elsewhere via chat?
            }
        });
    }

    private static void createAndShowGui() {
        LayoutExample mainPanel = new LayoutExample();

        JFrame frame = new JFrame("Title");
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