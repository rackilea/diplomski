private void removeAlarmManager() {
    AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

    Intent intent = new Intent(this, AlarmReceiver.class);

    intent.getIntExtra("timerNumberOneId", 0);
    PendingIntent sender = PendingIntent.getBroadcast(this, 1, intent, PendingIntent.FLAG_CANCEL_CURRENT);

    intent.getIntExtra("timerNumberTwoId", 0);
    PendingIntent senderTwo = PendingIntent.getBroadcast(this, 2, intent, PendingIntent.FLAG_CANCEL_CURRENT);

    intent.getIntExtra("timerNumberThreeId", 0);
    PendingIntent senderThree = PendingIntent.getBroadcast(this, 3, intent, PendingIntent.FLAG_CANCEL_CURRENT);

    intent.getIntExtra("timerNumberFourId", 0);
    PendingIntent senderFour = PendingIntent.getBroadcast(this, 4, intent, PendingIntent.FLAG_CANCEL_CURRENT);

    am.cancel(sender);
    am.cancel(senderTwo);
    am.cancel(senderThree);
    am.cancel(senderFour);

    Log.v(TAG, "Alarms Removed");
}