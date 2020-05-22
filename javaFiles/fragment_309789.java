@Override
    public void onCreate() {
        super.onCreate();
        String CHANNEL_ID = "my_service";
        String CHANNEL_NAME = "My Background Service";
        if (Build.VERSION.SDK_INT >= 26) {
            // in APIs 26+ we should show a notifications
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,
                    CHANNEL_NAME, NotificationManager.IMPORTANCE_NONE);
            ((NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE)).createNotificationChannel(channel);

            Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setCategory(Notification.CATEGORY_SERVICE).setPriority(PRIORITY_MIN).build();

            startForeground(NOTIFICATION_ID, notification);
        }

}