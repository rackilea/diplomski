import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

public class Main2 {
  public JComponent makeUI() {
    JTree tree = new ColorTree2();
    tree.setCellRenderer(new MyTreeCellRenderer());
    tree.setOpaque(false);
    return new JScrollPane(tree);
  }

  static class ColorTree2 extends JTree {
    @Override public void paintComponent(Graphics g) {
      Graphics2D g2 = (Graphics2D) g.create();
      g2.setColor(getBackground());
      g2.fillRect(0, 0, getWidth(), getHeight());
      for (int i = 0; i < getRowCount(); i++) {
        Object o = getPathForRow(i).getLastPathComponent();
        g2.setColor(getNodeColor(o));
        Rectangle r = getRowBounds(i);
        g2.fillRect(0, r.y, getWidth(), r.height);
      }
      g2.dispose();
      super.paintComponent(g);
    }
  }

  static class MyTreeCellRenderer extends DefaultTreeCellRenderer {
    private final Color color = new Color(0x0, true);
    @Override public Color getBackgroundSelectionColor() {
      return color;
    }
    @Override public Color getBackgroundNonSelectionColor() {
      return color;
    }
    @Override public Component getTreeCellRendererComponent(
        JTree tree, Object value, boolean selected, boolean expanded,
        boolean leaf, int row, boolean hasFocus) {
      JLabel l = (JLabel) super.getTreeCellRendererComponent(
          tree, value, selected, expanded, leaf, row, hasFocus);
      if (getRowOfNode(value) == 2) {
        l.setForeground(Color.WHITE);
      }
      return l;
    }
  }

  public static Color getNodeColor(Object value) {
    switch (getRowOfNode(value)) {
    case 1:
      return Color.RED;
    case 2:
      return Color.BLUE;
    default:
      return Color.YELLOW;
    }
  }

  public static int getRowOfNode(Object value) {
    if (value instanceof DefaultMutableTreeNode) {
      DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
      return node.getPath().length;
    }
    return -1;
  }

  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new Main2().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}