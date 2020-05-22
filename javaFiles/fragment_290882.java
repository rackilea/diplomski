import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class OptionPaneUtilities {

    public static void main(String[] args) {
        OptionPaneUtilities.showMessage(null, "I sometimes I think we forget just how flexible the JOptionPane API is and what it can do. A little effort could go a long way");
    }

    public static void showMessage(Component comp, String message) {
        JTextArea ta = new JTextArea(message, 1, 20);
        ta.setWrapStyleWord(true);
        ta.setLineWrap(true);
        ta.setOpaque(false);
        ta.setBorder(null);
        ta.setEditable(false);
        ta.setFocusable(false);
        JOptionPane.showMessageDialog(comp, ta);
    }

}