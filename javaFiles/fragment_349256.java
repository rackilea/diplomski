@Override
public void onMessageReceived(RemoteMessage remoteMessage) {

    //here you trigger the LocalBroadcastManager in your activity
    Intent pushNotification = new Intent(AppConfig.PUSH_NOTIFICATION);
    LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);

}