try {
    final long thread_id = transactionCursor.getLong(transactionCursor.getColumnIndex("thread_id"));
    final Uri thread = Uri.parse("content://sms/conversations/" + thread_id);
    final int numberOfDeletedMessages = getContentResolver().delete(thread, null, null);
    Log.v(TAG, "Number of deleted messages equals to " + numberOfDeletedMessages);
} catch (Exception e) {
    Log.e(TAG,e.getMessage(),e);
}