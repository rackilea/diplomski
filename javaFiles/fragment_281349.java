Notification noti = new Notification.Builder(mContext)
         .setContentTitle("New mail from " + sender.toString())
         .setContentText(subject)
         .setSmallIcon(R.drawable.new_mail)
         .setLargeIcon(aBitmap)
         .build();