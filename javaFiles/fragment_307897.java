public class DisplayReminderNotification extends Activity {

    private Context context = this;

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the notification ID.
        int notifID = 1234;

        String reminderName = "reminder";

        // PendingIntent stores the Activity that should be launched when the
        // user taps the notification.
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("NotifID", 123);
        i.putExtra("notification_tap", true);

        PendingIntent displayIntent = PendingIntent.getActivity(this, notifID,
                i, 0);

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notif = new Notification(R.drawable.ic_launcher,
                reminderName, System.currentTimeMillis());

        CharSequence from = "Here's your reminder:";

        CharSequence message = reminderName;
        notif.setLatestEventInfo(this, from, message, displayIntent);

        // Fire up the notification.
        nm.notify(notifID, notif);

        // Destroy the activity/notification.
        finish();

    }
}