import java.awt.*;
import javax.swing.*;

public class ProgressBarTest extends JFrame {

    public static void main(String args[]) {
        UIManager.put("ProgressBar.repaintInterval", 100);
        UIManager.put("ProgressBar.border",
            BorderFactory.createLineBorder(Color.blue, 2));
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame f = new JFrame();
                f.setLayout(new GridLayout(0, 1, 5 , 5));
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.add(createBar());
                f.add(createBar());
                f.add(createBar());
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }

            private JProgressBar createBar() {
                JProgressBar progressBar = new JProgressBar(0, 100);
                progressBar.setValue(50);
                return progressBar;
            }
        });
    }
}