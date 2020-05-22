import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

public class JProgressBarTest {

public static void main(final String[] args) {
    UIManager.put("ProgressBar.background", Color.BLACK);
    UIManager.put("ProgressBar.foreground", Color.RED);
    UIManager.put("ProgressBar.selectionBackground", Color.YELLOW);
    UIManager.put("ProgressBar.selectionForeground", Color.BLUE);
    final JProgressBar progressBar = new JProgressBar();

    new JFrame() {
        {
            getContentPane().setLayout(new FlowLayout());
            getContentPane().add(progressBar);
            progressBar.setValue(50);
            progressBar.setStringPainted(true);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(400, 200);
            setLocationRelativeTo(null);
            setVisible(true);
        }
    };
    }
}