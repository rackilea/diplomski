import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.OverlayLayout;
import javax.swing.UIManager;

//http://stackoverflow.com/questions/14560680/jprogressbar-low-values-will-not-be-displayed
public class ProgressSample {

    private JFrame frame = new JFrame("GlassPane instead of JLayer");
    private JLabel label;
    private GridBagConstraints gbc = new GridBagConstraints();
    private JProgressBar progressSeven;

    public ProgressSample() {
        frame.setLayout(new FlowLayout());
        frame.add(new JButton("test"));
        frame.add(new JCheckBox("test"));
        frame.add(new JRadioButton("test"));
        // Nothing is displayed if value is lover that 6
        JProgressBar progressSix = new JProgressBar(0, 100);
        progressSix.setValue(2);
        frame.add(progressSix);
        JPanel wrappingPanel = new JPanel();
        OverlayLayout mgr = new OverlayLayout(wrappingPanel);
        wrappingPanel.setLayout(mgr);
        progressSeven = new JProgressBar(0, 100);
        progressSeven.setAlignmentX(0.0f);
        progressSeven.setAlignmentY(0.0f);
        frame.add(wrappingPanel);
        label = new JLabel();
        label.setText("<html>Blablabla, Blablablabla<br>" + "Blablabla, Blablablabla<br>" + "Blablabla, Blablablabla</html>");
        label.setAlignmentX(0.0f);
        label.setAlignmentY(0.0f);
        wrappingPanel.add(label);
        wrappingPanel.add(progressSeven);
        Container glassPane = (Container) frame.getRootPane().getGlassPane();
        glassPane.setVisible(true);
        glassPane.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProgressSample dialogTest = new ProgressSample();
    }
}