// the time now
Calendar calendar = Calendar.newInstance();

// noon tomorrow
calendar.add(Calendar.DAY_OF_YEAR, 1);
calendar.set(Calendar.HOUR_OF_DAY, 12);
calendar.set(Calendar.MINUTE, 0);
calendar.set(Calendar.SECOND, 0);

alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
    Toast.makeText(this, "Alarm set", Toast.LENGTH_LONG).show();