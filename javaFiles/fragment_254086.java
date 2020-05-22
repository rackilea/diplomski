import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class NumberActions extends JPanel {
    private ButtonGroup buttonGroup = new ButtonGroup();

    public NumberActions() {
        ItemListener itemListener = new MyItemListener();
        setLayout(new GridLayout(1, 0));
        for (int i = 0; i < 10; i++) {
            JRadioButton rBtn = createRadioBtn(i);
            rBtn.addItemListener(itemListener);
            buttonGroup.add(rBtn);
            add(rBtn);
        }
    }

    private JRadioButton createRadioBtn(int i) {
        String text = String.valueOf(i);
        JRadioButton rBtn = new JRadioButton(text);
        rBtn.setActionCommand(text);

        int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
        InputMap inputMap = rBtn.getInputMap(condition);
        ActionMap actionMap = rBtn.getActionMap();
        Action action = new MyAction(rBtn);

        bindAction(inputMap, actionMap, action, KeyEvent.VK_0 + i);
        bindAction(inputMap, actionMap, action, KeyEvent.VK_NUMPAD0 + i);

        return rBtn;
    }

    private void bindAction(InputMap inputMap, ActionMap actionMap, Action action, int mnemonic) {
        KeyStroke keyStroke = KeyStroke.getKeyStroke(mnemonic, 0);
        inputMap.put(keyStroke, keyStroke.toString());
        actionMap.put(keyStroke.toString(), action);
    }

    private class MyItemListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent iEvt) {
            if (iEvt.getStateChange() == ItemEvent.SELECTED) {
                AbstractButton btn = (AbstractButton) iEvt.getSource();
                System.out.println("Button: " + btn.getActionCommand());
            }
        }
    }

    private class MyAction extends AbstractAction {
        private AbstractButton btn;

        public MyAction(AbstractButton btn) {
            this.btn = btn;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            btn.requestFocusInWindow();
            btn.doClick();
        }
    }

    private static void createAndShowGui() {
        NumberActions mainPanel = new NumberActions();

        JFrame frame = new JFrame("NumberActions");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}