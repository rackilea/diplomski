@Override
public void onReceive(Context context, Intent intent) {
    String action = intent.getAction();
    if (action.equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)) {
        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, 0));
        DownloadManager manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Cursor cursor = manager.query(query);
        if (cursor.moveToFirst()) {
            if (cursor.getCount() > 0) {
                int status = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS));
                if (status == DownloadManager.STATUS_SUCCESSFUL) {
                    String file = cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_LOCAL_FILENAME));
                    // So something here on success
                } else {
                    int message = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_REASON));
                    // So something here on failed.
                }
            }
        }
    }
}