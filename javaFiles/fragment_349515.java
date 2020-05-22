NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE); 
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { 
NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "My Notifications", NotificationManager.IMPORTANCE_DEFAULT);
// Configure the notification channel.
notificationChannel.setDescription("Channel description");

notificationChannel.enableLights(true);   
notificationChannel.setLightColor(Color.RED); 

notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
notificationChannel.enableVibration(true);     

 notificationManager.createNotificationChannel(notificationChannel);
} 

NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID) .setVibrate(new long[]{0, 100, 100, 100, 100, 100}) 
    .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)) 
    .setSmallIcon(R.mipmap.ic_launcher) .setContentTitle("Content Title") 
    .setContentText("Content Text"); 
notificationManager.notify(NOTIFICATION_ID, builder.build());