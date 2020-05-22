@Override
protected void onResume() {
    super.onResume();
    //do the query again every time on resume
    Cursor c = mExpenseDb.queryCategories(mSettings.getCurrentAccount().getId());
    //mAdapter is a SimpleCursorAdapter, set its cursor to the new one 
    mAdapter.changeCursor(c);
}

@Override
protected void onPause() {
    super.onPause();
    //mAdapter is a SimpleCursorAdapter, invalidate its data and set it cursor to null on Activity pause
    mAdapter.notifyDataSetInvalidated();

    mAdapter.changeCursor(null);
}