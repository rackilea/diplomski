import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

public class DatabaseTree implements TreeSelectionListener {

  JFrame frame;
  DefaultTreeModel treeModel;
  DefaultTreeCellRenderer cellRenderer;
  JScrollPane pane;
  JTree tree;
  Connection connection;
  PreparedStatement pst;
  ResultSet rs;
  List<String> databaseNode = new ArrayList<String>();

  public DatabaseTree() {
    // JFrame.setDefaultLookAndFeelDecorated(true);
    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    DefaultMutableTreeNode root = new DefaultMutableTreeNode();
    root.setUserObject(new JLabel("Databases", new ImageIcon("/images/g.jpg"), JLabel.CENTER));
    treeModel = new DefaultTreeModel(root);
    try {
      Class.forName("com.mysql.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ganesh", "root",
          "admina");
      pst = connection.prepareStatement("show databases");
      rs = pst.executeQuery();
      while (rs.next()) {
        String text = rs.getString(1);
        databaseNode.add(text);
        root.add(new DefaultMutableTreeNode(new JLabel(text, new ImageIcon("/images/g.jpg"),
            JLabel.CENTER)));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    tree = new JTree(treeModel);
    tree.setCellRenderer(new MyTreeCellRenderer());
    tree.addTreeSelectionListener(this);
    tree.setRootVisible(true);
    tree.expandRow(0);
    pane = new JScrollPane(tree);
    frame.setContentPane(pane);
    frame.setVisible(true);

  }

  public static void main(String args[]) {
    new DatabaseTree();
  }

  @Override
  public void valueChanged(TreeSelectionEvent e) {
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
    String text = ((JLabel) node.getUserObject()).getText();
    JLabel label = null;
    if (databaseNode.contains(text)) {
      if (node.getChildCount() == 0) {
        try {
          pst = connection.prepareStatement("show tables in " + text);
          rs = pst.executeQuery();
          while (rs.next()) {
            String data = rs.getString(1);
            label = new JLabel(data);
            node.add(new DefaultMutableTreeNode(label));
          }
        } catch (Exception ee) {
          ee.printStackTrace();
        }
      }
    }
  }

  class MyTreeCellRenderer extends DefaultTreeCellRenderer {

    JLabel label;

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected,
                                                  boolean expanded, boolean leaf, int row,
                                                  boolean hasFocus) {

      DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
      label = (JLabel) node.getUserObject();

      if (selected) {
        label.setBackground(backgroundSelectionColor);
        label.setForeground(textSelectionColor);
      } else {
        label.setBackground(backgroundNonSelectionColor);
        label.setForeground(textNonSelectionColor);
      }
      return label;
    }
  }
}