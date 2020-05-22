import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class TestPanelSwitch {
    private JFrame frame;
    private NumberPanel numberPanel;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TestPanelSwitch window = new TestPanelSwitch();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public TestPanelSwitch() {
        initialize();
    }
    private void initialize() {
        // see above
    }
}