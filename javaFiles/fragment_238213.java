import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TreeCollapseTest {
  private final JTree tree = new JTree();
  public JComponent makeUI() {
    JPanel p = new JPanel(new BorderLayout());
    p.add(new JButton(new AbstractAction("collapse") {
      @Override public void actionPerformed(ActionEvent e) {
        // if (tree.isRootVisible()) {
        int row = tree.getRowCount() - 1;
        //while (row >= 0) { //collapses all nodes
        while (row > 0) { //collapses only child nodes of root node
          tree.collapseRow(row);
          row--;
        }
      }
    }), BorderLayout.SOUTH);
    p.add(new JScrollPane(tree));
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
    f.getContentPane().add(new TreeCollapseTest().makeUI());
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}