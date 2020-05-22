private void setAlarm(Calendar targetCal){

   /* HERE */     Intent intent = new Intent(getBaseContext(), AlarmService.class);
        final int _id = (int) System.currentTimeMillis();

      /* HERE */  PendingIntent pendingIntent = PendingIntent.getService(this,_id,intent,PendingIntent.FLAG_ONE_SHOT);

        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
    ......
    .....