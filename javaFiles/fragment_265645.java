import java.awt.*;
import javax.swing.*;
public class CircleIconTest {
  public JComponent makeUI() {
    JPanel p = new JPanel();
    p.add(new JButton(new CircleIcon()));
    return p;
  }
  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new CircleIconTest().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}
class CircleIcon implements Icon {
  @Override
  public void paintIcon(Component c, Graphics g, int x, int y) {
    //g.drawOval(10, 10, 20, 20);
    Graphics2D g2 = (Graphics2D) g.create();
    //Draw the icon at the specified x, y location:
    g2.drawOval(x, y, getIconWidth() - 1, getIconHeight() - 1);
    //or
    //g2.translate(x, y);
    //g2.drawOval(0, 0, getIconWidth() - 1, getIconHeight() - 1);
    g2.dispose();
  }

  @Override
  public int getIconWidth() {
    return 20;
  }

  @Override
  public int getIconHeight() {
    return 20;
  }
}