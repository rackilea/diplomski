button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent arg0) {
        root.add(new DefaultMutableTreeNode("Row 4"));
        ((DefaultTreeModel) tree.getModel()).nodesWereInserted(
                root, new int[]{root.getChildCount()-1});
    }
});