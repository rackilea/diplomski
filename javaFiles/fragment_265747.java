Notification mNotification = new Notification.Builder(this)
    .setContentTitle("New Message Received")
    .setContentText("Hi I am your friend Sam")
    // Here you can specify an image but it will display as icon on the left side of Notification.
    .setSmallIcon(R.drawable.friend)
    .setContentIntent(pIntent)
    .setSound(soundUri)
    .build();