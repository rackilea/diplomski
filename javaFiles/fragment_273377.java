import java.awt.EventQueue;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class NonUnfocusingDialogExample {

    public static void main(final String[] args) {
        EventQueue.invokeLater(() -> {
            final JDialog dialog = new JDialog();
            dialog.setType(Window.Type.POPUP);
            dialog.getContentPane().add(new JLabel("Hello World!", 
                    SwingConstants.CENTER));
            dialog.pack();
            dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            dialog.setTitle("Test Dialog");
            dialog.setLocationByPlatform(true);
            dialog.setVisible(true);
        });
    }

}