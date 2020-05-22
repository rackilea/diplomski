import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FlashScreenTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame mainFrame = new JFrame("Main App");
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.add(new MainAppPanel());
            mainFrame.pack();
            mainFrame.setLocationRelativeTo(null);

            FlashScreenPanel dialogPanel = new FlashScreenPanel();
            JDialog dialog = new JDialog(mainFrame, "Flash Screen", ModalityType.APPLICATION_MODAL);
            dialog.add(dialogPanel);
            dialog.pack();
            dialog.setLocationRelativeTo(null);

            dialogPanel.startProgress();
            dialog.setVisible(true);

            mainFrame.setVisible(true);
        });
    }
}

class FlashScreenPanel extends JPanel {
    public static final String LOADING = "Loading...";
    public static final String PLEASE_WAIT = "Please Wait...";
    public static final String LOADING_POLICE_STATION = "Loading Police Station...";
    public static final String ALMOST_DONE = "Almost Done...";
    public static final String DONE = "Done";
    private static final int TIMER_DELAY = 50;

    private JProgressBar jb = new JProgressBar(0, 2000);
    private JLabel statusLabel = new JLabel("", SwingConstants.CENTER);

    public FlashScreenPanel() {
        setPreferredSize(new Dimension(800, 400));

        statusLabel.setForeground(Color.CYAN);
        statusLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
        jb.setStringPainted(true);
        JPanel bottomPanel = new JPanel(new BorderLayout(20, 20));
        bottomPanel.add(jb, BorderLayout.PAGE_START);
        bottomPanel.add(statusLabel, BorderLayout.CENTER);

        int eb = 40;
        setBorder(BorderFactory.createEmptyBorder(eb, eb, eb, eb));
        setLayout(new GridLayout(0, 1));
        add(new JLabel()); // dummy component to move prog bar lower
        add(bottomPanel);
    }

    public void startProgress() {
        statusLabel.setText(LOADING);
        new Timer(TIMER_DELAY, new ActionListener() {
            private int i = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                i += 20;
                jb.setValue(i);
                if (i == 500) {
                    statusLabel.setText(PLEASE_WAIT);
                } else
                if (i == 1000) {
                    statusLabel.setText(LOADING_POLICE_STATION);
                } else
                if (i == 1200) {
                    statusLabel.setText(PLEASE_WAIT);
                } else
                if (i == 1600) {
                    statusLabel.setText(ALMOST_DONE);
                } else
                if (i == 1980) {
                    statusLabel.setText(DONE);
                } else
                if (i == 2000) {
                    ((Timer) e.getSource()).stop();
                    Window win = SwingUtilities.getWindowAncestor(FlashScreenPanel.this);
                    win.dispose();
                }
            }
        }).start();
    }
}

class MainAppPanel extends JPanel {
    public MainAppPanel() {
        setPreferredSize(new Dimension(600, 400));
    }
}