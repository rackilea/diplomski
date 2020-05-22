NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(GcmMessageHandler.this)
            .setSmallIcon(R.drawable.ic_launcher)
            .setContentTitle("Notification")
            .setStyle(new NotificationCompat.BigTextStyle()
            .bigText(message))

            .setSound(alarmSound)

            .setVibrate(vibrate)


            .setAutoCancel(true)
            .setContentText(message);



            mBuilder.setContentIntent(alarmIntent);


            Notification notification = new Notification();
            notification. defaults |= Notification.DEFAULT_VIBRATE;


            mNotificationManager.notify(UniqueID, mBuilder.build());


            Toast.makeText(getApplicationContext(),message, Toast.LENGTH_LONG).show();