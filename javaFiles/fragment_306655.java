AlarmManager mgr = (AlarmManager) context
                .getSystemService(Context.ALARM_SERVICE);
 Intent notificationIntent = new Intent(context,
                UpdateService.class);
 PendingIntent pendingIntent=PendingIntent.getService(context, requestCode, Intent.parseIntent(), 0);
  mgr.setInexactRepeating(AlarmManager.RTC_WAKEUP,
        System.currentTimeMillis(), AlarmManager.INTERVAL_HOUR, pendingIntent);