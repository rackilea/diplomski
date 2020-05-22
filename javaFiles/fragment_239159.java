//get rows and columns of your JTable
int nRow = yourtable.getRowCount(), nCol = yourtable.getColumnCount();

//Loop row by row
for (int i = 0; i < nRow; i++) {
    //each row loop its columns 
    for (int j = 0; j < nCol; j++) {
        //check if your value is not empty or null then change to 0
        if (yourtable.getValueAt(i, j).equals("") || yourtable.getValueAt(i, j) == null) {
            yourtable.setValueAt(0, i, j);
        }
    }
}