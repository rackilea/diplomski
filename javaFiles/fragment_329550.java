ublic void getSelectedTableData(SelectionEvent e) {
  int[] row = viewer.getTable().getSelectionIndices();
  Arrays.sort(row);
  if (row.length > 0) {
     for(int i = row.length-1; i >= 0; i--){
        if(((Button) e.getSource()).getText() == "Plotting")   
           AplotPlotDataModel.getInstance().buildPlotArray(row[i]);
        else {
           AplotPDFDataModel.getInstance().buildArray(row[i]);
        }
     }
  }
 }