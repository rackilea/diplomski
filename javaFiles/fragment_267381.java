import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
//https://stackoverflow.com/questions/14560680/jprogressbar-low-values-will-not-be-displayed
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
        // but this works value is higher that 6
        progressSeven = new JProgressBar(0, 100);
        progressSeven.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                label.setBounds(
                        (int) progressSeven.getBounds().getX(),
                        (int) progressSeven.getBounds().getY(),
                        label.getPreferredSize().width,
                        label.getPreferredSize().height);
            }
        });
        progressSeven.setValue(7);
        frame.add(progressSeven);
        label = new JLabel();
        label.setText("<html> Concurency Issues in Swing<br>"
                + " never to use Thread.sleep(int) <br>"
                + " durring EDT, simple to freeze GUI </html>");
        label.setPreferredSize(new Dimension(label.getPreferredSize().width, label.getPreferredSize().height));
        Container glassPane = (Container) frame.getRootPane().getGlassPane();
        glassPane.setVisible(true);
        glassPane.setLayout(null);
        glassPane.add(label, gbc);
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