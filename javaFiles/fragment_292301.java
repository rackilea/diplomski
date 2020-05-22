private static class TreeRenderer extends DefaultTreeCellRenderer {

    private static final Icon closed =
        (Icon) UIManager.get("InternalFrame.maximizeIcon");
    private static final Icon open =
        (Icon) UIManager.get("InternalFrame.minimizeIcon");

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value,
        boolean sel, boolean exp, boolean leaf, int row, boolean hasFocus) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        String s = node.getUserObject().toString();
        if ("sports".equals(s)) {
            setOpenIcon(open);
            setClosedIcon(closed);
        } else {
            setOpenIcon(getDefaultOpenIcon());
            setClosedIcon(getDefaultClosedIcon());
        }
        super.getTreeCellRendererComponent(
            tree, value, sel, exp, leaf, row, hasFocus);
        return this;
    }
}