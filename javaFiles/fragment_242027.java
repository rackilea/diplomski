tree.setCellRenderer(new TreeCellRenderer() {
        @Override
        public Component getTreeCellRendererComponent(
                JTree tree, Object value, 
                boolean selected, boolean expanded,
                boolean leaf, int row, boolean hasFocus) {
            return tree.getCellEditor().getTreeCellEditorComponent(tree, value, 
                                                      selected, expanded, leaf, row);
        }

    });