tree.setCellRenderer( new DefaultTreeCellRenderer(){

    public Component getTreeCellRendererComponent( tree, value, selected, false,                      
                                                   false,0, hasFocus ){

        super.getTreeCellRendererComponent( tree, value, selected, false, false,0, 
                                            hasFocus );

        if( value instanceof DefaultMutableTreeNode){

            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
            Object userValue = node.getUserObject();

            if( value instanceof File ){
                 setText( ((File) value).getName();
            }
        }

        return this;
    }
}