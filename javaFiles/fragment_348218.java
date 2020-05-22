@Override
public void onCreate() {
    ...
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        startForeground(NOTIFICATION_ID, notification);
    }
    ...
}