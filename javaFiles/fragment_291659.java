private void manageListView() {
    mCsr = myDb.getAllData();
    if (mSCA == null) {
        // Builds the Adapter for the List
        mSCA = new SimpleCursorAdapter(
                this,
                R.layout.mylistview_item, mCsr,
                columns_to_list,
                item_layout_ids_for_list,
                0
        );
        mList.setAdapter(mSCA); // Ties the Adapter to the ListView
    } else {
        mSCA.swapCursor(mCsr); // Refresh the List
    }
}