//... some code here

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // if you don't want the alarm to go off even in Doze mode, use
            // setExact instead
            mAlarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,
                    alarmTimeMillis,
                    getPendingIntent(context);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mAlarmManager.setExact(AlarmManager.RTC_WAKEUP,
                    alarmTimeMillis,
                    getPendingIntent(context);
        } else {
            // Inexact time was only introduced in API 19+. Before that, all was exact time
            mAlarmManager.set(AlarmManager.RTC_WAKEUP,
                    alarmTimeMillis,
                    getPendingIntent(context);
        }