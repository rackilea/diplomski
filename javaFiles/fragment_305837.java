public class MyFrame extends JFrame implements MouseListener {
private static final long serialVersionUID = 1L;
String myReturnValue = null;

private static String firstn = "Kategorien";
private static String del = "\\|";
private DefaultMutableTreeNode top = new DefaultMutableTreeNode(firstn);
private DefaultTreeModel model = new DefaultTreeModel(top);
private JTree baum = null;
public String ret = null;

public MyFrame(Map<String, String> tree) {

    this.setBounds(100, 100, 500, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setupTree(tree);

    baum.addMouseListener(this);
    this.setVisible(true);
}

private void setupTree(Map<String, String> tree) {
    baum = new JTree(createNodes(tree));
    baum.setEditable(false);
    baum.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
    baum.setToggleClickCount(2);
    baum.setRootVisible(true);
    JScrollPane treeView = new JScrollPane(baum);
    this.getContentPane().add(treeView);
    this.setVisible(true);
}
private DefaultMutableTreeNode createNodes(Map<String, String> file) {
    /*
     * Iterate over the Map
     */
    for (Map.Entry<String, String> entry : file.entrySet()) {
        String key = entry.getKey();
        String values[] = entry.getValue().split(del);

        DefaultMutableTreeNode parent = top;

        /*
         * Iterate over the values (Path)
         */
        for (String k : values) {
            DefaultMutableTreeNode n = null;

            /*
             * Check if Node already exists
             */
            Enumeration<?> e = parent.children();
            while (e.hasMoreElements()) {
                n = (DefaultMutableTreeNode) e.nextElement();
                if (k.equals(n.getUserObject())) {
                    // Existing node matches; use that one.
                    break;
                }
                n = null;
            }
            if (n == null) {
                // No existing node matches; add it.
                n = new DefaultMutableTreeNode(k);
                parent.add(n);
            }
            parent = n;
        }
        parent.add(new DefaultMutableTreeNode(key));
    }
    return top;
}
// ... other @Overrides
@Override
    public void mousePressed(MouseEvent e) {
    TreePath selPath = baum.getPathForLocation(e.getX(), e.getY());
    if (selPath != null) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) selPath.getLastPathComponent();
        if (e.getClickCount() == 2 && model.isLeaf(node)) {
            this.myReturnValue = node.toString();
        }
    }

}