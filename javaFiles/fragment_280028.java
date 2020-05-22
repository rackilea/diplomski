import java.awt.*;
import java.util.Arrays;
import javax.swing.*;

public class GridBayLayoutSlotTest {
  private JComponent makeUI() {
    GridBagLayout layout = new GridBagLayout();
    JPanel panel_playerBuffs = new JPanel();
    panel_playerBuffs.setLayout(layout);

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = gbc.weighty = 1.0;
    gbc.insets = new Insets(2, 2, 2, 2);

    gbc.gridx = 1;
    gbc.gridy = 1;
    panel_playerBuffs.add(new JLabel("located at 1, 1"), gbc);
    gbc.gridx = 3;
    gbc.gridy = 1;
    panel_playerBuffs.add(new JLabel("located at 3, 1"), gbc);

    EventQueue.invokeLater(() -> {
      int[][] a = layout.getLayoutDimensions();
      System.out.println(Arrays.deepToString(a));
      System.out.format("isEmpty(%d, %d): %s%n", 2, 1, isEmpty(a, 2, 1));
      System.out.format("isEmpty(%d, %d): %s%n", 3, 1, isEmpty(a, 3, 1));
    });

    return panel_playerBuffs;
  }
  private static boolean isEmpty(int[][] a, int x, int y) {
    int[] w = a[0];
    int[] h = a[1];
    return w[x] == 0 || h[y] == 0;
  }
  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new GridBayLayoutSlotTest().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}