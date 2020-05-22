public SyncManager(ContentResolver context) {
        mContentResolver = context;
    }

    @Override
    public void run() {

       // General data
       mIntent = new Intent();
       mIntent.setData(GeneralDataColumns.CONTENT_URI);
       mCursor = mContentResolver.query(mIntent.getData(), GENERAL_PROJECTION, selection, null, GeneralDataColumns.DEFAULT_SORT_ORDER);
   }