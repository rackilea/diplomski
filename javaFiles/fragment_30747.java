public void generateNotification(NotificationCompat.Builder notificationBuilder) {
    NotificationManager notificationManager =
            (NotificationManager) 
   context.getSystemService(Context.NOTIFICATION_SERVICE);
    String CHANNEL_ID = "my_channel_01";
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        CharSequence name = context.getString(R.string.app_name);
   // The user-visible name of the channel.
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, 
    importance);
    // Create a notification and set the notification channel.
        notificationManager.createNotificationChannel(mChannel);
    }
    PreferenceHelper preferenceHelper = PreferenceHelper.getInstance(context);
    preferenceHelper.setNotificationId(preferenceHelper.getNotificationId() + 1);
    notificationManager.notify(preferenceHelper.getNotificationId(), 
   notificationBuilder.build());
  }