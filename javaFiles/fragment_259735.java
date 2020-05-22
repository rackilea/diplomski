public Notifier(Context mContext){
    this.mContext = mContext;
    mNotifyMgr =
      (NotificationManager) mContext.getSystemService(mContext.NOTIFICATION_SERVICE);
    mBuilder =
(NotificationCompat.Builder) new NotificationCompat.Builder(mContext)
    .setSmallIcon(R.drawable.notification_icon)
    .setContentTitle("foo")
    .setContentText("bar")
    .setOngoing(true);
}