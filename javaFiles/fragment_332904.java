//AlarmService.java

Intent myIntent = new Intent(getApplicationContext(), AlarmAlertBroadcastReciever.class);
ByteArrayOutputStream bos = new ByteArrayOutputStream();
ObjectOutputStream out = null;
try {
    out = new ObjectOutputStream(bos);
    out.writeObject(alarm);
    out.flush();
    byte[] data = bos.toByteArray();
    myIntent.putExtra("alarm", data);
} catch (IOException e) {
    e.printStackTrace();
} finally {
    try {
        bos.close();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, myIntent, PendingIntent.FLAG_CANCEL_CURRENT);

AlarmManager alarmManager = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
alarmManager.set(AlarmManager.RTC_WAKEUP, alarm.getAlarmTime().getTimeInMillis(), pendingIntent);