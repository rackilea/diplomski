model = new DefaultTableModel() {

    @Override
    public boolean isCellEditable(int row, int column) {
        return true; //use the row and col to determine which 
                    //cells are editable. If you want all, have this return true. 
    }

};