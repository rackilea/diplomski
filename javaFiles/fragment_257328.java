public void datachange(){
    count++;
    Vector<String> newRow = new Vector<>();
    newRow.addElement("Row"+count+"-Column1");
    newRow.addElement("Row"+count+"-Column2");
    newRow.addElement("Row"+count+"-Column3");
    DFMO.addRow(newRow);
    //rowData.addElement(row);
    DFMO.fireTableDataChanged();
}