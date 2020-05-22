public class NotificationPublisher extends BroadcastReceiver {

private static final String TAG = "NotificationPublisher";
public static String NOTIFICATION_ID = "notification-id";
public static String NOTIFICATION = "notification";

@Override
public void onReceive(Context context, Intent intent) {
    NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    if (Build.VERSION.SDK_INT >= 26) {
        NotificationChannel channel = new NotificationChannel("Reminders", "Reminders", NotificationManager.IMPORTANCE_DEFAULT);
        notificationManager.createNotificationChannel(channel);
    }
    Notification notification = intent.getParcelableExtra(NOTIFICATION);
    int id = intent.getIntExtra(NOTIFICATION_ID, 0);
    Log.i(TAG, "notification sent");
    notificationManager.notify(id, notification);
}