import java.awt.*;
import java.util.Arrays;
import java.util.stream.Stream;
import javax.swing.*;

public class MenuSubElementsTest {
  public JComponent makeUI() {
    JMenu jMenuAlgorithms = new JMenu("MenuAlgorithms");

    JMenuItem jCheckBoxMenuEnableAll = new JMenuItem("Enable all");
    jCheckBoxMenuEnableAll.addActionListener(e -> {
      for (MenuElement me: jMenuAlgorithms.getPopupMenu().getSubElements()) {
        System.out.println("debug1: " + me.getClass().getName());
        if (me instanceof JCheckBoxMenuItem) {
          ((JCheckBoxMenuItem) me).setSelected(true);
        }
      }
      //or: getJCheckBoxMenuItem(jMenuAlgorithms).forEach(r -> r.setSelected(true));
    });

    JMenuItem jCheckBoxMenuDisableAll = new JMenuItem("Disable all");
    jCheckBoxMenuDisableAll.addActionListener(e -> {
      getJCheckBoxMenuItem(jMenuAlgorithms).forEach(r -> r.setSelected(false));
    });

    jMenuAlgorithms.add(new JCheckBoxMenuItem("SPEA", true));
    jMenuAlgorithms.add(new JCheckBoxMenuItem("NSGAII", true));
    jMenuAlgorithms.addSeparator();
    jMenuAlgorithms.add(jCheckBoxMenuEnableAll);
    jMenuAlgorithms.add(jCheckBoxMenuDisableAll);

    JMenuBar jMenuBar = new JMenuBar();
    jMenuBar.add(jMenuAlgorithms);

    JPanel p = new JPanel(new BorderLayout());
    p.add(jMenuBar, BorderLayout.NORTH);
    return p;
  }
  private static Stream<JCheckBoxMenuItem> getJCheckBoxMenuItem(MenuElement p) {
    Class<JCheckBoxMenuItem> clz = JCheckBoxMenuItem.class;
    return stream(p).filter(clz::isInstance).map(clz::cast);
  }
//   public static Stream<MenuElement> stream(MenuElement p) {
//     return Arrays.stream(p.getSubElements())
//       .map(MenuSubElementsTest::stream).reduce(Stream.of(p), Stream::concat);
//   }
  public static Stream<MenuElement> stream(MenuElement p) {
    return Stream.concat(Stream.of(p), Arrays.stream(p.getSubElements())
      .peek(me -> System.out.println("debug2: " + me.getClass().getName()))
      .flatMap(MenuSubElementsTest::stream));
  }
  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new MenuSubElementsTest().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}