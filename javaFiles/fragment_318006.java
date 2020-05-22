import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;

public class TopRightCornerLabelLayerUITest {
  public static JComponent makeUI() {
    JTabbedPane tab = new JTabbedPane();
    tab.addTab("New tab1", new JLabel("1"));
    tab.addTab("New Tab2", new JLabel("2"));
    JPanel p = new JPanel(new BorderLayout());
    p.add(new JLayer<JComponent>(tab, new TopRightCornerLabelLayerUI()));
    return p;
  }
  private static void createAndShowUI() {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().add(makeUI());
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        createAndShowUI();
      }
    });
  }
}
class TopRightCornerLabelLayerUI extends LayerUI<JComponent> {
  private JLabel l = new JLabel("A Label at right corner");
  private JPanel rubberStamp = new JPanel();
  @Override public void paint(Graphics g, JComponent c) {
    super.paint(g, c);
    Dimension d = l.getPreferredSize();
    int x = c.getWidth() - d.width - 5;
    SwingUtilities.paintComponent(g, l, rubberStamp, x, 2, d.width, d.height);
  }
}