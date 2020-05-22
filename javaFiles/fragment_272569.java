dataProvider = new AsyncDataProvider<StringEntity>() {

  @Override
  protected void onRangeChanged(final HasData<StringEntity> display) {
    final Range visibleRange = display.getVisibleRange();
    final int start = visibleRange.getStart();
    final int length = visibleRange.getLength();

    final List<StringEntity> subList = new ArrayList<StringEntity>();
    for (long position = start; position < start + length; position ++)
      subList.add(new StringEntity(position, "Please wait..."));

    display.setRowData(start, subList);

    // now perform your request...
    // onSuccess, set the rowData again (to the updated values)
  }
}