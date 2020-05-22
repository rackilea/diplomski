public ListView<String> jlstDefects ;
   public TextField fldDefectName;

   private void jltDefectsListItemSelected()
   {

    int ndx = jlstDefects.getSelectionModel().getSelectedIndex();
    if (ndxJlstDefectSelector == ndx)
        return;
    ndxJlstDefectSelector = ndx;
    String strSelectedDefectName = lstDefectList.getDefect(ndx);
    fldDefectName.setText(strLocalDefectName);


}