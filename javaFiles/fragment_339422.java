DefaultTableCellRenderer renderer = new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable arg0,Object arg1, boolean arg2, boolean arg3, int arg4, int arg5) {
         Component tableCellRendererComponent = super.getTableCellRendererComponent(arg0, arg1, arg2, arg3, arg4, arg5);
         int align = DefaultTableCellRenderer.CENTER;
         if(condition){
             align = DefaultTableCellRenderer.LEFT;
         }
        ((DefaultTableCellRenderer)tableCellRendererComponent).setHorizontalAlignment(align);
         return tableCellRendererComponent;
    }
};
t.getColumnModel().getColumn(COLUMN).setCellRenderer(renderer);