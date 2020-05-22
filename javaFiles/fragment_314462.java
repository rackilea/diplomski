try {
        long time = System.currentTimeMillis();
        Intent i = new Intent(getApplicationContext(), AlarmReceiver.class);
        PendingIntent alarmSender = PendingIntent.getBroadcast(getApplicationContext(), 0, i, 0);
        AlarmManager am = (AlarmManager) getApplication().getSystemService(Context.ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, time, alarmSender);
    } catch(Exception e){
        Toast.makeText(getBaseContext(), "Parsing error. Format:\ndd/MM/yyyy and HH:mm", Toast.LENGTH_SHORT).show();
    }