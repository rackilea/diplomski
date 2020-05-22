public  void  shownotification(){
Bitmap largeImage = BitmapFactory.decodeResource(getResources(),R.drawable.dog);

Intent pauseIntent = new Intent("com.mypackage.ACTION_PAUSE_MUSIC");
PendingIntent pausePendingIntent = PendingIntent.getBroadcast(this, 1, pauseIntent, 0);
// Similarly you can create an intent and pending intent pair for each action you want just change the string in intent constructor

Notification channel = new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID_1)
        .setSmallIcon(R.drawable.ic_music)
        .setContentTitle(notificationTitleText
        )
        .setContentText(notificationDescText)
        .setLargeIcon(largeImage)
        .addAction(R.drawable.ic_like,"like",null)
        .addAction(R.drawable.ic_prev,"prev",null)
        .addAction(R.drawable.ic_pause,"pause",pausePendingIntent)  //like this attach every action with respective pending intent
        .addAction(R.drawable.ic_next,"next",null)
        .addAction(R.drawable.ic_dislike,"dislike",null)
        .setStyle(new android.support.v4.media.app.NotificationCompat.MediaStyle()
        .setShowActionsInCompactView(1,2,3))
        .build();

mNotificationManagerCompat.notify(1,channel);}