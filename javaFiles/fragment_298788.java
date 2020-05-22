import java.awt.*;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class TestPleaseWait {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainPanel mainPanel = new MainPanel();
            JFrame frame = new JFrame("Application");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(mainPanel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

@SuppressWarnings("serial")
class MainPanel extends JPanel {
    private static final int PREF_W = 600;
    private static final int PREF_H = 450;

    public MainPanel() {
        add(new JButton(new AbstractAction("Without Background Thread") {
            {
                putValue(MNEMONIC_KEY, KeyEvent.VK_O);
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                final PleaseWait wait = new PleaseWait();
                wait.setVisible(true);
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e1) {
                }
                wait.setVisible(false);
            }
        }));
        add(new JButton(new AbstractAction("With Background Thread") {
            private JDialog waitDialog = null;
            private MyWaitPanel myWaitPanel = new MyWaitPanel();

            {
                putValue(MNEMONIC_KEY, KeyEvent.VK_W);
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (waitDialog == null) {
                    Component component = MainPanel.this;
                    Window win = SwingUtilities.getWindowAncestor(component);
                    waitDialog = new JDialog(win, "Please Wait", ModalityType.APPLICATION_MODAL);
                    waitDialog.add(myWaitPanel);
                    waitDialog.pack();
                    waitDialog.setLocationRelativeTo(win);
                }

                new Thread(() -> {
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e1) {
                    }
                    SwingUtilities.invokeLater(() -> {
                        waitDialog.setVisible(false);
                    });

                }).start();
                waitDialog.setVisible(true);
            }
        }));
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }
}

@SuppressWarnings("serial")
class MyWaitPanel extends JPanel {
    private JProgressBar progressBar = new JProgressBar();

    public MyWaitPanel() {
        progressBar.setIndeterminate(true);

        JLabel waitLabel = new JLabel("Please Wait", SwingConstants.CENTER);
        waitLabel.setFont(waitLabel.getFont().deriveFont(Font.BOLD, 40));

        int ebGap = 10;
        setBorder(BorderFactory.createEmptyBorder(ebGap, ebGap, ebGap, ebGap));
        setLayout(new BorderLayout(ebGap, ebGap));
        add(waitLabel, BorderLayout.PAGE_START);
        add(progressBar);
    }
}

@SuppressWarnings("serial")
class PleaseWait extends JFrame {

    public PleaseWait() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();

        Dimension screenDimensions = toolkit.getScreenSize();
        setSize(300, 100); // set size based on screen size
        setTitle("Please wait");
        Container container = getContentPane();
        setLocation(new Point(screenDimensions.width * 1 / 4 + 200,
                screenDimensions.height * 1 / 4 + 200));

        JPanel panel = new JPanel();
        JLabel wait = new JLabel("Please wait");
        Dimension buttonsSize = new Dimension(300, 100);
        panel.setPreferredSize(buttonsSize);
        wait.setPreferredSize(buttonsSize);
        panel.setLayout(new BorderLayout());
        panel.add(wait, BorderLayout.CENTER);
        container.add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // unresizable
    }
}