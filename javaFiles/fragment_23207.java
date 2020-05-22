JTree tree = new JTree();
    tree.setDragEnabled(true);
    tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

    tree.setTransferHandler(new TransferHandler(null) {
        public int getSourceActions(JComponent c) {
            return MOVE;
        }

        protected Transferable createTransferable(JComponent c) {
            JTree tree = (JTree) c;
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();

            if (node.isLeaf()) {
                // TODO create the Transferable instance for the selected leaf
            } else {
                return null;
            }
        }
    });