import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class TestMenuBindings {

    public static void main(String[] args) {
        JMenuBar menuBar = new JMenuBar();
        final JMenu menu = new JMenu("Print");
        final Action oAction = new PrintAction("O",KeyStroke.getKeyStroke(KeyEvent.VK_O, 0));
        menu.add(oAction);
        menuBar.add(menu);
        JFrame frm = new JFrame("Frame");
        frm.setJMenuBar(menuBar);

        final JTextArea area = new JTextArea("Here working no accelerators", 10, 40);
        frm.add(new JScrollPane(area));

        frm.add(new JTextField("Here working accelerators"), BorderLayout.SOUTH);

        KeyboardFocusManager kfm = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        kfm.addKeyEventDispatcher( new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                KeyStroke keyStroke = KeyStroke.getKeyStrokeForEvent(e);
                // pass only KEY_TYPED for letters with no modifiers in the editing area, suppress KEY_PRESSED, KEY_RELEASED
                return area.isFocusOwner() && keyStroke.getModifiers()==0 && e.getID()!=KeyEvent.KEY_TYPED && Character.isLetter(e.getKeyChar());
            }
        });

        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frm.pack();
        frm.setVisible(true);
    }

    private static class PrintAction extends AbstractAction {
        private String str;
        public PrintAction(String aPrintStr, KeyStroke aMnemonic) {
            super("Print: " + aPrintStr);
            str = aPrintStr;
            putValue(Action.ACCELERATOR_KEY, aMnemonic);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(str);
        }
    }
}