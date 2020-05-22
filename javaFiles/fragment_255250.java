import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.metal.MetalSliderUI;

public class SliderOnlyLeftMouseButtonDragTest {
  public JComponent makeUI() {
    JSlider slider00 = new JSlider(0,10,5);
    JSlider slider01 = new JSlider(0,10,5);
    slider01.setUI(new MetalSliderUI() {
      protected TrackListener createTrackListener(JSlider slider) {
        return new TrackListener() {
          @Override public void mousePressed(MouseEvent e) {
            if(!SwingUtilities.isLeftMouseButton(e)) {
              return;
            }
            super.mousePressed(e);
          }
        };
      }
    });
    JPanel p = new JPanel();
    p.add(slider00);
    p.add(slider01);
    return p;
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        createAndShowGUI();
      }
    });
  }
  public static void createAndShowGUI() {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.getContentPane().add(new SliderOnlyLeftMouseButtonDragTest().makeUI());
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}