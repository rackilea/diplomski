Intent intentAlarm = new Intent(this, AlarmReceiver.class);
    AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    // Set the alarm for a particular time.

    PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT);

    try {
        pendingIntent.cancel();
        alarmManager.cancel(pendingIntent);
    } catch (Exception e) {
        e.printStackTrace();

    }