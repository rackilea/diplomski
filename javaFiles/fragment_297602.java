public void notificationCreateGu(String User) {

        Log.d(TAG,nameOfTheService+"BUG createnotification for received CHAT messages useruidOfTheFriendNear="+newMessageUserUidOfSender);
        Intent it = new Intent(this,ActivityWillReceiveWithGetExtras.class);
        it.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        it.putExtra(USER,user);
        StoreValuesClass.count=StoreValuesClass.count+2;
        PendingIntent pi = PendingIntent.getActivity(this, StoreValuesClass.count,it, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new NotificationCompat.Builder(this)
                .setTicker(newMessageUserUidOfSender )
                .setSmallIcon(android.R.mipmap.sym_def_app_icon)
                .setContentTitle("Title Message ")
                .setContentText(String.valueOf(newMessageUserUidOfSender))
                .setContentIntent(pi)
                .setAutoCancel(true)
                .build();



        int m;
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
         m= StoreValuesClass.count=StoreValuesClass.count+2;
        notificationManager.notify((m), notification);

    }