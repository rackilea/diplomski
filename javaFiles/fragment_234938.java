IconValue iconValue = new IconValue() {
    @Override
    public Icon getIcon(Object value) {
        return UIManager.getIcon("FileView.directoryIcon");
    }
};

DefaultTreeRenderer treeCellRenderer = new DefaultTreeRenderer(iconValue) {
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        Component c = super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        if (selected && leaf) {
            c.setBackground(Color.RED);
        } else {
            setBackground(tree.getBackground());
        }
        return c;
    }
};