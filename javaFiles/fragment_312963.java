tree.addTreeSelectionListener(new TreeSelectionListener() {
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
        FileNodes fileNode = (FileNodes)node.getUserObject();
        System.out.println("You selected " + fileNode.getFile().getAbsolutePath());
    }
});