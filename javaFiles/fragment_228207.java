// Obtain the intent that started this activity by calling
// Activity.getIntent() and pass it into this method to
// get the associated string.

private CharSequence getMessageText(Intent intent) {
    Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);
    if (remoteInput != null) {
        return remoteInput.getCharSequence(KEY_NOTIFICATION_REPLY);
    }
    return null;
}