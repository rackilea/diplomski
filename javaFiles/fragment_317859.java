import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class AlterSpaceBinding extends JPanel {
    private JButton myButton = new JButton("My Button -- associate with \"B\" key");

    public AlterSpaceBinding() {
        myButton = alterDefaultButtonAction(myButton, KeyEvent.VK_B);
        myButton.addActionListener(l -> {
            System.out.println("button pressed");
        });
        add(myButton);
        add(new JButton("Second Button -- no change"));

    }

    public static JButton alterDefaultButtonAction(JButton button, int desiredKeyCode) {

        // get the correct InputMap
        InputMap inputMap = button.getInputMap(JComponent.WHEN_FOCUSED);

        // get both key strokes for space key, but pressed and released
        KeyStroke spaceKeyPressed = KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false);
        KeyStroke spaceKeyReleased = KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true);

        // key stroke for desired key code
        KeyStroke desiredKeyPressed = KeyStroke.getKeyStroke(desiredKeyCode, 0, false);
        KeyStroke desiredKeyReleased = KeyStroke.getKeyStroke(desiredKeyCode, 0, true);

        // share the Action with desired KeyStroke
        inputMap.put(desiredKeyPressed, inputMap.get(spaceKeyPressed));
        inputMap.put(desiredKeyReleased, inputMap.get(spaceKeyReleased));

        // disable original KeyStrokes (optional)
        inputMap.put(spaceKeyPressed, "none");
        inputMap.put(spaceKeyReleased, "none");

        return button;
    }

    private static void createAndShowGui() {
        AlterSpaceBinding mainPanel = new AlterSpaceBinding();

        JFrame frame = new JFrame("AlterSpaceBinding");
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