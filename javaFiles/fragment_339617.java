Notification notification = new Notification(R.drawable.logo2, "app is running on the background!", System.currentTimeMillis());

notification.flags |= Notification.FLAG_FOREGROUND_SERVICE;

PendingIntent contentIntent = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);

notification.setLatestEventInfo(this, "title", "message!", contentIntent);

this.startForeground(1023, notification);