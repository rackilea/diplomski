public void setValueAt(Object value,int row,int col){

    if(value == null || value.toString().isEmpty()){
        return;
    }

    data[row][col].setContent(value.toString());
    fireTableCellUpdated(row,col);
}