Date now = new Date();
SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
Date parsedDate = format.parse(YOUR_PICKED_DATE_AS_STRING);
long alertTime = parsedDate.getTime() - now.getTime();

Intent someIntent = new Intent(getApplicationContext(), YourClass.class);
PendingIntent pending = PendingIntent.getBroadcast(getApplicationContext(), 0, someIntent, 0);

AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
manager.set(AlarmManager.