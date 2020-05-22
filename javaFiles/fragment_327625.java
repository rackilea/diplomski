private static final long FIVE_DAYS_MILIS = 24 * 5 * 60 * 60 * 1000;

    private void readMessage() {
        Uri inboxURI = Uri.parse("content://sms/inbox");
        long currentTimeMilis = System.currentTimeMillis();
        // Time milis before 5 days
        long milisBefore5Days = currentTimeMilis - FIVE_DAYS_MILIS;
        // Where clause saying that date should be greater that milis before 5
        // days.
        String selection = "date > ?";
        String selectionArgs[] = { Long.toString(milisBefore5Days) };
        String[] reqCols = new String[] { "_id", "address", "body", "date" };
        ContentResolver cr = getContentResolver();
        Cursor c = cr.query(inboxURI, reqCols, selection, selectionArgs, null);
    }