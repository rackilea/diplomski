NotificationManager mManager;    
mManager = (NotificationManager) this.getApplicationContext().getSystemService(this.getApplicationContext().NOTIFICATION_SERVICE);

 //Put the name of the class where you want to go on clicking the notification.. I used MainActivity

       Intent intent1 = new Intent(this.getApplicationContext(),MainActivity.class);

       Notification notification = new Notification(R.drawable.ic_launcher,"This is a test message!", System.currentTimeMillis());

       intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP| Intent.FLAG_ACTIVITY_CLEAR_TOP);

       PendingIntent pendingNotificationIntent = PendingIntent.getActivity( this.getApplicationContext(),0, intent1,PendingIntent.FLAG_ONE_SHOT);
       notification.flags |= Notification.FLAG_AUTO_CANCEL;
       notification.setLatestEventInfo(this.getApplicationContext(), "Notification", "This is a test message!", pendingNotificationIntent);

       mManager.notify(0, notification);