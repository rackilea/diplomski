private class MyRenderer extends DefaultTreeCellRenderer {

    private Icon okIcon;

    public MyRenderer(Icon okIcon) {
        this.okIcon = okIcon;
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value,
        boolean sel, boolean exp, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(
            tree, value, sel, exp, leaf, row, hasFocus);
        YourMutableTreeNode node = (YourMutableTreeNode) value;
        if (leaf && node.getStatus().equals("OK")) {
            setIcon(okIcon);
        }
        return this;
    }
}