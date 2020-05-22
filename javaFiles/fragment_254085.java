import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class RadioButtonSelectableByNumbers {
    private JFrame frame;
    private JRadioButton buttons[];
    private ButtonGroup group;

    public RadioButtonSelectableByNumbers() {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RadioButtonSelectableByNumbers().createAndShowGui();
            }
        });
    }

    public void createAndShowGui() {
        frame = new JFrame("frame");
        frame.setDefaultCloseOperation(JFrame);
        buttons = new JRadioButton[5];
        group = new ButtonGroup();

        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));

        for (int i = 0; i < buttons.length; i++) {
            JRadioButton rbtn = createButton(i);
            buttons[i] = rbtn;
            frame.getContentPane().add(rbtn);
        }

        frame.pack();
        frame.setVisible(true);
    }

    private JRadioButton createButton(int i) {
        String name = String.valueOf(i + 1);
        int stdMnemonic = KeyEvent.VK_1 + i;  // for standard number keys
        int numpadMnemonic = KeyEvent.VK_NUMPAD1 + i;  // for numpad number keys
        Action action = new CustomAction(name, stdMnemonic);
        JRadioButton rBtn = new JRadioButton(action);
        group.add(rBtn);

        // bindings active if window is focused. Component doesn't have to be focused
        int condition = JComponent.WHEN_IN_FOCUSED_WINDOW; 
        InputMap inputMap = rBtn.getInputMap(condition);
        ActionMap actionMap = rBtn.getActionMap();
        KeyStroke keyStroke = KeyStroke.getKeyStroke(stdMnemonic, 0);
        KeyStroke keyStroke2 = KeyStroke.getKeyStroke(numpadMnemonic, 0);
        inputMap.put(keyStroke, keyStroke.toString());
        actionMap.put(keyStroke.toString(), action);
        inputMap.put(keyStroke2, keyStroke2.toString());
        actionMap.put(keyStroke2.toString(), action);
        return rBtn;
    }

    class CustomAction extends AbstractAction {
        public CustomAction(String name, Integer mnemonic, Integer modifier) {
            super(name);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(mnemonic, modifier));
        }

        public CustomAction(String name, Integer mnemonic) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("radio clicked: " + e.getActionCommand());
        }
    }
}