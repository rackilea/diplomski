import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;

public class Demo2 {
  public JComponent makeUI() {
    //String s = "";
    String s = "\uD83D\uDE01"; //\u1F601
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
    DefaultMutableTreeNode leaf = new DefaultMutableTreeNode("Leaf: " + s);
    root.add(leaf);

    JTree tree1 = new JTree(root);
    tree1.setFont(new Font("Lucida Sans", 0, 16));

    JTree tree2 = new JTree(root);
    tree2.setFont(new Font("DejaVu Sans", 0, 16));

    JPanel p = new JPanel(new GridLayout(2, 1));
    p.add(new JScrollPane(tree1));
    p.add(new JScrollPane(tree2));
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
    f.getContentPane().add(new Demo2().makeUI());
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}