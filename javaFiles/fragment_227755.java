...
Intent mapIntent = new Intent(this, MainActivity.class);
mapIntent.putExtra("Start", xxxx);
mapIntent.putExtra("Start", xxxx);
PendingIntent notificationIntent = PendingIntent.getActivity(this, 0, mapIntent, 0);

Notification notification = new NotificationCompat.Builder(this)
...