public static class Tree extends TreeTableView {

    public Tree(ListTreeTableModelOnColumns treeTableModel) {
        super(treeTableModel);

        setTreeCellRenderer(new Renderer());
    }

    class Renderer extends ColoredTreeCellRenderer  {
        @Override
        public void customizeCellRenderer(@NotNull JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            Node node = (Node)value;
            NodeModel model = node.getUserObject();

            append(model.Name);
        }

    }
}