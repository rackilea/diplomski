Table removeEmptyRows(Table inputTable, String columnName){

  Table returnTable = cloneTable(inputTable);
  returnTable.clearRows();

  for (int row = 0; row < inputTable.getRowCount(); row++){
    String rowValue = inputTable.getString(row, columnName);

    if (!isNullOrBlank(rowValue) && isNumeric(rowValue)){
      returnTable.addRow(inputTable.getRow(row));
    }
  }

  return returnTable;

}