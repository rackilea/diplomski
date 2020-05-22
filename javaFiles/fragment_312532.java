public void updateInUi() {

    // send your request and get list of updated items
    List<> newItems = getYourUpdatedListHere()
    yourDataList.addAll(newItems);
    adapter.notifyDataSetChanged();
}