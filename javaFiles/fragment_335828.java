private void setAlarmManager() {
    long wakeUpTime = timerPreferences.getStartTime() + millisToCount;
    long wakeUpTimeTwo = timerPreferences.getStartTimeTwo() + millisToCountTwo;
    long wakeUpTimeThree = timerPreferences.getStartTimeThree() + millisToCountThree;
    long wakeUpTimeFour = timerPreferences.getStartTimeFour() + millisToCountFour;

    Log.v(TAG, "Millis For AM " + millisToCount);
    Log.v(TAG, "Millis Two For AM " + millisToCountTwo);
    Log.v(TAG, "Millis Three For AM " + millisToCountThree);
    Log.v(TAG, "Millis Four For AM " + millisToCountFour);

    Log.v(TAG, "Paused Time For AM " + pausedTime);
    Log.v(TAG, "Paused Time Two For AM " + pausedTimeTwo);
    Log.v(TAG, "Paused Time Three For AM " + pausedTimeThree);
    Log.v(TAG, "Paused Time Four For AM " + pausedTimeFour);

    AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

    Intent intent = new Intent(this, AlarmReceiver.class);

    if (millisToCount > 0) {
        intent.putExtra("timerNumberOneId", 1);
        PendingIntent sender = PendingIntent.getBroadcast(this, 1, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            am.setAlarmClock(new AlarmManager.AlarmClockInfo(wakeUpTime, sender), sender);
        } else {
            am.set(AlarmManager.RTC_WAKEUP, wakeUpTime, sender);
        }
        Log.v(TAG, "Alarm Manager Set");
    }

    if (millisToCountTwo > 0) {
        intent.putExtra("timerNumberTwoId", 2);
        PendingIntent senderTwo = PendingIntent.getBroadcast(this, 2, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            am.setAlarmClock(new AlarmManager.AlarmClockInfo(wakeUpTimeTwo, senderTwo), senderTwo);
        } else {
            am.set(AlarmManager.RTC_WAKEUP, wakeUpTimeTwo, senderTwo);
        }
        Log.v(TAG, "Alarm Manager Two Set");
    }

    if (millisToCountThree > 0) {
        intent.putExtra("timerNumberThreeId", 3);
        PendingIntent senderThree = PendingIntent.getBroadcast(this, 3, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            am.setAlarmClock(new AlarmManager.AlarmClockInfo(wakeUpTimeThree, senderThree), senderThree);
        } else {
            am.set(AlarmManager.RTC_WAKEUP, wakeUpTimeThree, senderThree);
        }
        Log.v(TAG, "Alarm Manager Three Set");
    }

    if (millisToCountFour > 0) {
        intent.putExtra("timerNumberFourId", 4);
        PendingIntent senderFour = PendingIntent.getBroadcast(this, 4, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            am.setAlarmClock(new AlarmManager.AlarmClockInfo(wakeUpTimeFour, senderFour), senderFour);
        } else {
            am.set(AlarmManager.RTC_WAKEUP, wakeUpTimeFour, senderFour);
        }
        Log.v(TAG, "Alarm Manager Four Set");
    }
}