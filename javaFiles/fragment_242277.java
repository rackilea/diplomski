private void startNotification() {

    // In older android versions, your Notification has to have a content
    // Intent, so that when the user clicks your Notification, something
    // happens default functionality
    Intent intent = new Intent(this, FlashLight.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    PendingIntent pend = PendingIntent.getActivity(this, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT);

    // checking the device has flash or not

    RemoteViews remoteViews;
    if (!hasFlash) {
        remoteViews = new RemoteViews(getPackageName(),
                R.layout.simple_notification);
    } else {
        remoteViews = new RemoteViews(getPackageName(),
                R.layout.mynotification);
    }
    NotificationCompat.Builder builder = new NotificationCompat.Builder(
            this).setSmallIcon(R.drawable.ic_launcher)
            .setContent(remoteViews).setContentIntent(pend);

    NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    Notification notification = builder.setContentTitle("Flashlight")
            .setContentText("Lighten your world!!!").build();
    notificationManager.notify(1, notification);

    // the intent that is started when the notification is clicked (works)
    Intent notificationIntent = new Intent(this, FlashLight.class);
    PendingIntent pendingMainNotificationIntent = PendingIntent
            .getActivity(this, 0, notificationIntent, 0);

    notification.contentIntent = pendingMainNotificationIntent;
    notification.flags |= Notification.FLAG_NO_CLEAR;

    // this is the intent that is supposed to be called when
    // the ON/OFF buttons are clicked
    Intent switchIntent = new Intent(this, switchOffButtonListener.class);
    PendingIntent pendingSwitchIntent = PendingIntent.getBroadcast(this, 0,
            switchIntent, 0);

    remoteViews.setOnClickPendingIntent(R.id.closeOnFlash,
            pendingSwitchIntent);

    Intent switchOnIntent = new Intent(this, switchOnButtonListener.class);
    PendingIntent pendingSwitchOnIntent = PendingIntent.getBroadcast(this,
            0, switchOnIntent, 0);

    remoteViews.setOnClickPendingIntent(R.id.onCloseFlash,
            pendingSwitchOnIntent);

    notificationManager.notify(1, notification);
}