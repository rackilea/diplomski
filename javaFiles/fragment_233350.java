selectedCells.addListener(new ListChangeListener() {
  @Override
  public void onChanged(Change c) {
    if(!selectedCells.isEmpty()) {
    TablePosition tablePosition = (TablePosition) selectedCells.get(0);
    Object val = tablePosition.getTableColumn().getCellData(tablePosition.getRow());
    courseName.setText(val.toString());
  }
}
});