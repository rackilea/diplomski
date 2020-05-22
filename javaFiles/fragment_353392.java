@Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.e(TAG, "From: " + remoteMessage.getFrom());
        Log.e(TAG, "Data Payload: " + remoteMessage.getData().toString());

        if (remoteMessage.getNotification() == null)
            return;
        // Check if message contains a notification payload.
        if(remoteMessage.getNotification() != null) {
            handleNotification(remoteMessage, remoteMessage.getNotification().getBody(), remoteMessage.getNotification().getTitle());
        }