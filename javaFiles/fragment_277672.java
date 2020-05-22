Intent intent = new Intent(this, yourBrodcastReceiver.class);
      intent.putExtra("notificationId",notificationId)
      intent.setAction(Long.toString(System.currentTimeMillis()))
      // pass all the value in intent
     PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
      Builder builder = new Notification.Builder(this):
      builder.setDeleteIntent(pendingIntent); // this is delete intent it will call when you cancel or swipe