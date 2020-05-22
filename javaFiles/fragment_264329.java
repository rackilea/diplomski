Intent notificationIntent=new Intent(context, Home.class);
generateNotification(context, message, notificationIntent);

private static void generateNotification(Context context, String message, Intent notificationIntent) {
    int icon = R.drawable.icon;
    long when = System.currentTimeMillis();
    NotificationManager notificationManager = (NotificationManager)
            context.getSystemService(Context.NOTIFICATION_SERVICE);
    Notification notification = new Notification(icon, message, when);
    String title = context.getString(R.string.app_name);

    // set intent so it does not start a new activity
    notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
            Intent.FLAG_ACTIVITY_SINGLE_TOP);
    PendingIntent intent =PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    notification.setLatestEventInfo(context, title, message, intent);
    notification.flags |= Notification.FLAG_AUTO_CANCEL;
    notificationManager.notify(0, notification);
}