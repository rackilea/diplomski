with(context.getSystemService(Context.ALARM_SERVICE) as AlarmManager) {
    // Create a PendingIntent which AlarmManager would raise.
    // You should have a BroadcastReceiver to receive the intent and send a push notification.

    setInexactRepeating(
        AlarmManager.RTC_WAKEUP,
        startAt.toEpochSecond() * 1000,
        intervalInMillis,
        pendingIntent
    )
}