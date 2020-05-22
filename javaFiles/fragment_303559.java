class changepicture:BroadcastReceiver() {
  override fun onReceive(context:Context, intent:Intent) {
    remoteViews00.setImageViewResource(R.id.imginNotification, R.drawable.musicimg)

    // Note: you need to use the exact same notification_id
    // to update the notification
    notificationManager00.notify(notification_id, builder00.build())
  }
}