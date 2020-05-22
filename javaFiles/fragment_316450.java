public static final String ACTION_FINISH = "yourpackagename.ACTION_FINISH";

@Override
public void onMessageReceived(RemoteMessage remoteMessage) {
    LocalBroadcastManager.getInstance(getApplicationContext())
        .sendBroadcast(new Intent(ACTION_FINISH));
}