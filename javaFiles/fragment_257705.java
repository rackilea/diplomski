public final class FileTree extends JPanel {

JTree tree;
DefaultMutableTreeNode root;
Path path;
List<String> lines;

public FileTree(String filepath) {
    try {
        root = new DefaultMutableTreeNode("root", true);
        this.path = Paths.get(filepath);
        lines = Files.readAllLines(path);
        getList(root, 0);
        setLayout(new BorderLayout());
        tree = new JTree(root);
        tree.setRootVisible(false);
        add(new JScrollPane((JTree) tree), "Center");
    } catch (IOException ex) {
        Logger.getLogger(FileTree.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public int getTab(int line) {
    String text = lines.get(line);
    return text.lastIndexOf("\t");

}

public boolean noChild(int line) {
    if (getTab(line) < getTab(line + 1)) {
        return false;
    }
    return true;

}


public TreeNode getNewNode(int line, int line2, DefaultMutableTreeNode node) {
    TreeNode treenode = node;
    int time = getTab(line) - getTab(line2);
    for (int i = 0; i < time; i++) {
        treenode = treenode.getParent();
    }
    return treenode;

}

public void getList(DefaultMutableTreeNode node, int line) {
    DefaultMutableTreeNode child = new DefaultMutableTreeNode(lines.get(line).trim());
    node.add(child);
    if (line + 1 > lines.size() - 1) {
        System.out.println("Finished");
        return;
    }
    if (!noChild(line)) { // have Children
        getList(child, line + 1);
    } else {             // no Children
        if (getTab(line) > getTab(line + 1)) {
            getList((DefaultMutableTreeNode) getNewNode(line, line + 1, node), line + 1);
        } else if (getTab(line) == getTab(line + 1)) {
            getList(node, line + 1);
        }
    }




}