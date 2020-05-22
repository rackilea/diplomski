import java.awt.Window;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MainSimple extends JPanel {
    private JDialog dialog;

    public MainSimple() {
        add(new JButton(new OpenDialogAction("Open Dialog", KeyEvent.VK_O)));
        add(new JButton(new DisposeAction("Exit", KeyEvent.VK_X)));
    }

    private class OpenDialogAction extends AbstractAction {
        public OpenDialogAction(String name, int mnemonic) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean test = true;
            // test = (dialog == null); // ***** comment or uncomment this line *****
            if (test) {
                Window win = SwingUtilities.getWindowAncestor(MainSimple.this);
                dialog = new MyDialog(win);
                dialog.pack();
                dialog.setLocationRelativeTo(win);
            }
            dialog.setVisible(true);            
        }
    }

    private class MyDialog extends JDialog {

        public MyDialog(Window win) {
            super(win, "My Dialog", ModalityType.APPLICATION_MODAL);
            add(new JButton(new DisposeAction("Close", KeyEvent.VK_C)));
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }

        @Override
        public void dispose() {
            String text = String.format("Disposing. This hashCode: %08X", hashCode());
            System.out.println(text);
            super.dispose();
        }
    }

    private class DisposeAction extends AbstractAction {

        public DisposeAction(String name, int mnemonic) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Component source = (Component) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(source);
            win.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui() {
        MainSimple mainPanel = new MainSimple();
        JFrame frame = new JFrame("Main");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

}