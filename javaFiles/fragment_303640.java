import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class KeyboardFun extends JPanel {
    private InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
    private ActionMap actionMap = getActionMap();

    public KeyboardFun() {
        setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        setLayout(new GridLayout(0, 8, 3, 3));
        for (char c = 'A'; c <= 'Z'; c++) {
            final String text = String.valueOf(c);
            JButton button = new JButton(text);
            button.addActionListener(e -> {System.out.println("Key pressed: " + text);});
            add(button);
            setBinding(c, button);
        }
    }

    private void setBinding(char c, final JButton button) {
        KeyStroke keyStroke = KeyStroke.getKeyStroke(Character.toLowerCase(c));
        inputMap.put(keyStroke, keyStroke.toString());
        actionMap.put(keyStroke.toString(), new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                button.doClick();
            }
        });
    }

    private static void createAndShowGui() {
        KeyboardFun mainPanel = new KeyboardFun();

        JFrame frame = new JFrame("KeyboardFun");
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