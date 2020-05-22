import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public final class SliderTooltipTest {
  private JComponent makeUI() {
    JSlider slider = new JSlider(1, 100000) {
      private SliderPopupListener popupHandler;
      @Override public void updateUI() {
        removeMouseMotionListener(popupHandler);
        removeMouseListener(popupHandler);
        removeMouseWheelListener(popupHandler);
        super.updateUI();
        popupHandler = new SliderPopupListener();
        addMouseMotionListener(popupHandler);
        addMouseListener(popupHandler);
        addMouseWheelListener(popupHandler);
      }
    };
    slider.setMajorTickSpacing(10000);
    slider.setPaintTicks(true);

    JPanel p = new JPanel();
    p.setBorder(BorderFactory.createEmptyBorder(50, 10, 50, 10));
    p.add(new JLabel("1"));
    p.add(slider);
    p.add(new JLabel("100Gb/s"));
    return p;
  }
  public static void main(String... args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        createAndShowGUI();
      }
    });
  }
  public static void createAndShowGUI() {
    try {
      for (UIManager.LookAndFeelInfo laf: UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(laf.getName())) {
          UIManager.setLookAndFeel(laf.getClassName());
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.getContentPane().add(new SliderTooltipTest().makeUI());
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}

class SliderPopupListener extends MouseAdapter {
  private final JWindow toolTip = new JWindow();
  private final JLabel label = new JLabel("", SwingConstants.CENTER);
  private final Dimension size = new Dimension(60, 20);
  private int prevValue = -1;

  public SliderPopupListener() {
    super();
    label.setOpaque(false);
    label.setBackground(UIManager.getColor("ToolTip.background"));
    //label.setBorder(UIManager.getBorder("ToolTip.border"));
    label.setBorder(BorderFactory.createLineBorder(Color.CYAN.darker()));
    toolTip.add(label);
    toolTip.setSize(size);
  }
  protected void updateToolTip(MouseEvent me) {
    JSlider slider = (JSlider) me.getComponent();
    int intValue = (int) slider.getValue();
    if (prevValue != intValue) {
      label.setText(String.format("%.3f", slider.getValue() / 1000f));
      Point pt = me.getPoint();
      pt.y = -size.height;
      SwingUtilities.convertPointToScreen(pt, me.getComponent());
      pt.translate(-size.width / 2, 0);
      toolTip.setLocation(pt);
    }
    prevValue = intValue;
  }
  @Override public void mouseDragged(MouseEvent me) {
    toolTip.setVisible(true);
    updateToolTip(me);
  }
  @Override public void mouseReleased(MouseEvent me) {
    toolTip.setVisible(false);
  }
}