DefaultTableModel model = new DefaultTableModel(...) {

     @Override
     Class<?> getColumnClass(int column) {
         if (column == hyperlinkColumn) {
             return URI.class;
         } 
         ... // handle other columns
         return super.getColumnClass(column);
     }

     @Override
     boolean isCellEditable(int row, int column) {
         if (column == hyperlinkColumn) {
            return false; 
         }
         ... // handle other columns
         return super.isCellEditable(row, column); 
     }
}