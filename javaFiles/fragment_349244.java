private class Renderer extends DefaultTreeCellRenderer{

        public  Renderer() {
            setOpaque(true);
        }
        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value,
                boolean selected, boolean expanded, boolean leaf, int row,
                boolean hasFocus) {

            super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
            setBackground(selected ? Color.LIGHT_GRAY : 
                (leaf ? Color.GRAY : tree.getBackground()));
            return this;
        }

    }