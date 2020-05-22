import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class MyButtonListener extends AbstractAction {
    private NoMouseListenerNeeded mainGui;

    public MyButtonListener(NoMouseListenerNeeded mainGui) {
        super("Press Me");
        putValue(MNEMONIC_KEY, KeyEvent.VK_P);
        this.mainGui = mainGui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object cell = mainGui.getSelectedCell();

        if (cell != null) {
            String message = "Selection is: " + cell;
            JOptionPane.showMessageDialog(mainGui, message, "Selection", JOptionPane.PLAIN_MESSAGE);
        }
    }
}