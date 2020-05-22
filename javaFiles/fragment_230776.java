setAlarm(2); //set the alarm for this day of the week

    public void setAlarm(int dayOfWeek) {
        // Add this day of the week line to your existing code
        alarmCalendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);

        alarmCalendar.set(Calendar.HOUR, AlarmHrsInInt);
        alarmCalendar.set(Calendar.MINUTE, AlarmMinsInInt);
        alarmCalendar.set(Calendar.SECOND, 0);
        alarmCalendar.set(Calendar.AM_PM, amorpm);

        Long alarmTime = alarmCalendar.getTimeInMillis();
        //Also change the time to 24 hours.
        am.setRepeating(AlarmManager.RTC_WAKEUP, alarmTime, 24 * 60 * 60 * 1000 , pi); 
}