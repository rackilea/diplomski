private void sendNotification(Notification nobj) {
    Intent intent = new Intent(context, NotificationActivity.class);
    intent.putExtra("Notification", "click");
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 
  PendingIntent.FLAG_ONE_SHOT);
    Uri defaultSoundUri = 
    RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
    Ringtone r = RingtoneManager.getRingtone(context, defaultSoundUri);
    r.play();
    NotificationCompat.Builder notificationBuilder = new 
   NotificationCompat.Builder(context)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(Html.fromHtml(nobj.title))
            .setContentText(Html.fromHtml(nobj.desc))
            .setAutoCancel(true)
            .setSound(defaultSoundUri)
            .setChannelId("my_channel_01")
            .setContentIntent(pendingIntent);
    generateNotification(notificationBuilder);

}