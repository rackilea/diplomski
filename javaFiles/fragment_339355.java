public void initTables() {

    dtm=new DefaultTableModel(0,0) {
        @Override
        public boolean isCellEditable(int row, int col) {
            return false;  // every cell is not editable
        }
    };

    dtm.addColumn("Name");
    dtm.addColumn("Age");
    dtm.addColumn("Gender"); 

}