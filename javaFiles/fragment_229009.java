mCursorLoader = new CursorLoader(
  mActivity,
  MyContentProvider.BASEURI,
  mColumns, 
  MyContentProviderColumns.CATEGORY + "=?", // category = ?
  new String[] { Integer.toString(mCurrentID) }, // pass in your category
  null);