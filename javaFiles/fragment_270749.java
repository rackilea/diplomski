import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ProgressBarPanel {

    private JComponent ui = null;

    ProgressBarPanel() {
        initUI();
    }

    public void initUI() {
        if (ui!=null) return;

        ui = new JPanel(new BorderLayout(4,4));
        ui.setBorder(new EmptyBorder(4,4,4,4));

        JProgressBar progressBar = new JProgressBar(0, 100) {
            public Dimension getPreferredSize() {
                // base this on a multiple of the default preferred size to
                // account for the size of the font used to paint the 
                // progress string
                return new Dimension(400,40);
            }
        };
        progressBar.setValue(50);
        progressBar.setStringPainted(true);
        ui.add(progressBar);

        ui.add(new JLabel("Status: N/A"), BorderLayout.PAGE_START);
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                ProgressBarPanel o = new ProgressBarPanel();

                JFrame f = new JFrame(o.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.pack();
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}