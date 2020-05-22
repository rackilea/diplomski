public void setValueAt(Object value,int row,int col){

    if(value == null || value.toString().isEmpty()){
        data[row][col].setContent("");
    }
    else {
        data[row][col].setContent(value.toString());
    }
    fireTableCellUpdated(row,col);
}