JButton change = new JButton("Change");
change.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

        if (node == null) {
            return;
        }

        Object nodeInfo = node.getUserObject();
        if (node.isLeaf()) {
            BookInfo book = (BookInfo) nodeInfo;
            book.bookName = "New Name";
            ((DefaultTreeModel)tree.getModel()).nodeChanged(node);
        }
        if (DEBUG) {
            System.out.println(nodeInfo.toString());
        }
    }
});