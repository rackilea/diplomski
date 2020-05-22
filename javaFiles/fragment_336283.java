import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.LayerUI;

public class ProgressBarLabelTest {
  private static JProgressBar makeProgressBar1(BoundedRangeModel model) {
    JProgressBar progressBar = new JProgressBar(model) {
      private JLabel label = new JLabel("000/100", SwingConstants.CENTER);
      private ChangeListener changeListener = null;
      @Override public void updateUI() {
        removeAll();
        if(changeListener!=null) removeChangeListener(changeListener);
        super.updateUI();
        EventQueue.invokeLater(new Runnable() {
          @Override public void run() {
            setLayout(new BorderLayout());
            changeListener = new ChangeListener() {
              @Override public void stateChanged(ChangeEvent e) {
                int iv = (int)(100 * getPercentComplete());
                label.setText(String.format("%03d/100", iv));
              }
            };
            addChangeListener(changeListener);
            add(label);
            label.setBorder(BorderFactory.createEmptyBorder(0,4,0,4));
          }
        });
      }
      @Override public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        Insets i = label.getInsets();
        d.width = label.getPreferredSize().width + i.left + i.right;
        return d;
      }
    };
    initProgressBar(progressBar);
    return progressBar;
  }
  private static JComponent makeProgressBar2(BoundedRangeModel model) {
    final JLabel label = new JLabel("000/100");
    label.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
    LayerUI<JProgressBar> layerUI = new LayerUI<JProgressBar>() {
      private final JPanel rubberStamp = new JPanel();
      @Override public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
        Dimension d = label.getPreferredSize();
        int x = (c.getWidth()  - d.width)  / 2;
        int y = (c.getHeight() - d.height) / 2;
        JLayer jlayer = (JLayer)c;
        JProgressBar progress = (JProgressBar)jlayer.getView();
        int iv = (int)(100 * progress.getPercentComplete());
        label.setText(String.format("%03d/100", iv));
        SwingUtilities.paintComponent(
          g, label, rubberStamp, x, y, d.width, d.height);
      }
    };
    JProgressBar progressBar = new JProgressBar(model) {
      @Override public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        Insets i = label.getInsets();
        d.width = label.getPreferredSize().width + i.left + i.right;
        return d;
      }
    };
    initProgressBar(progressBar);
    return new JLayer<JProgressBar>(progressBar, layerUI);
  }
  public JComponent makeUI() {
    final BoundedRangeModel m = new DefaultBoundedRangeModel();
    JProgressBar progressBar0 = new JProgressBar(m);
    initProgressBar(progressBar0);
    progressBar0.setStringPainted(true);
    JPanel p = new JPanel();
    p.add(progressBar0);
    p.add(makeProgressBar1(m));
    p.add(makeProgressBar2(m));
    p.add(new JButton(new AbstractAction("+10") {
      private int i = 0;
      @Override public void actionPerformed(ActionEvent e) {
        m.setValue(i = (i>=100) ? 0 : i + 10);
      }
    }));
    return p;
  }
  private static void initProgressBar(JProgressBar progressBar) {
    progressBar.setOrientation(SwingConstants.VERTICAL);
    progressBar.setStringPainted(false);
    progressBar.setForeground(Color.GREEN);
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() { createAndShowGUI(); }
    });
  }
  public static void createAndShowGUI() {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.getContentPane().add(new ProgressBarLabelTest().makeUI());
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}