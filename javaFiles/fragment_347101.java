import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class WinMenuItemIconTest {
  private static JMenuBar makeManuBar() {
    JMenuItem menuItem0 = new JMenuItem("Command", createIcon());

    JMenuItem menuItem1 = new JMenuItem("LEFT bug?", createIcon());
    menuItem1.setHorizontalTextPosition(SwingConstants.LEFT);
    //menuItem1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

    JMenuItem menuItem2 = new JMenuItem("CENTER bug?", createIcon());
    menuItem2.setHorizontalTextPosition(SwingConstants.CENTER);

    JMenuItem menuItem3 = new JMenuItem("RIGHT_TO_LEFT", createIcon());
    menuItem3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

    JMenu menu = new JMenu("Menu");
    menu.add(menuItem0);
    menu.add(menuItem1);
    menu.add(menuItem2);
    menu.add(menuItem3);

    JMenuBar menuBar = new JMenuBar();
    menuBar.add(menu);
    return menuBar;
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      //NOTE: Bug happens with Windows L&F
      String name = UIManager.getSystemLookAndFeelClassName();
      try {
        UIManager.setLookAndFeel(name);
      } catch (Exception e) {
        e.printStackTrace();
      }
      JFrame frame = new JFrame("Test");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setJMenuBar(makeManuBar());
      frame.setSize(320, 240);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
    });
  }
  protected static ImageIcon createIcon() {
    BufferedImage bi = new BufferedImage(25, 25, BufferedImage.TYPE_INT_ARGB);
    Graphics g = bi.createGraphics();
    g.setColor(Color.RED);
    g.fillOval(0, 0, 25, 25);
    g.dispose();
    return new ImageIcon(bi);
  }
}