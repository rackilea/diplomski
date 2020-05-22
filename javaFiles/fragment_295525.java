JTree tree = new JTree();
// need to register manually 
// (that is does _not_ automatically as f.i. JTable
// either register the tree
ToolTipManager.sharedInstance().registerComponent(tree);
// or set a not-null tooltip text to the tree
// tree.setToolTipText("default if node has none or outside node");
TreeCellRenderer r = new DefaultTreeCellRenderer() {

    @Override
    public Component getTreeCellRendererComponent(JTree tree,
            Object value, boolean sel, boolean expanded, boolean leaf,
            int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,
                row, hasFocus);
        setToolTipText("I'm a leaf: " + leaf);
        return this;
    }

};
tree.setCellRenderer(r);