import java.awt.Dimension;
import java.awt.Toolkit;

public class MyCustomDialog extends javax.swing.JDialog {
    public MyCustomDialog() {

        super(); // Invoke any JDialog initialization code.

        Toolkit t = Toolkit.getDefaultToolkit();
        if (t.getScreenSize().height < 600) {
            setSize(getWidth(), 600);
            // Add your scrollpane, etc.
        } else {
            setSize(600, 800); // No need to add a scroll pane.
        }
    }
}