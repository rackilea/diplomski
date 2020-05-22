import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class ProgressBar extends JFrame {

    private JProgressBar progressBar;

    public ProgressBar() {
        super("loading");
        setSize(200, 100);
        Container content = getContentPane();
        content.setLayout(new BorderLayout());
        progressBar = new JProgressBar();
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setStringPainted(true);
        progressBar.setBorder(null);
        content.add(progressBar, BorderLayout.SOUTH);
        setVisible(true);
    }

    void updateProgress(final int newValue) {
        progressBar.setValue(newValue);
    }

    public void setValue(final int j) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                updateProgress(j);
            }
        });
    }

    public static void main(final String Args[]) {
        ProgressBar myProgressBar = new ProgressBar();
        int i = 0;
        while (i <= 100) {
            System.out.println("" + i + "%");
            myProgressBar.setValue(i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
            i = i + 5;
        }
    }
}