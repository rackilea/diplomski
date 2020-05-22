AlarmManager alarmManager = (AlarmManager)mContext.getSystemService(Context.ALARM_SERVICE);
    Intent intent = new Intent(BackgroundReceiver.BROADCAST_ACTION);
    intent.addCategory(BackgroundReceiver.CATEGORY);
    PendingIntent alarmIntent = PendingIntent.getBroadcast(mContext, SYNC_REQUEST_CODE, intent, 0);

    alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeInMillis() + 30000, 30000, alarmIntent);