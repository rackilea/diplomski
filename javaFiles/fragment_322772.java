@Override
protected void onRangeChanged(final HasData<YourObject> display) {

  // update browser URL without navigating
  History.newItem(historyMapper.getToken(place), false);

  ...
}