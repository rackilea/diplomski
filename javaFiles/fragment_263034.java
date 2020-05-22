Intent i = new Intent(this, MainActivity.class);
startForeground(
        NOTIF_MONITORING,
        new NotificationCompat.Builder(getApplicationContext())
                .setSmallIcon(R.drawable.ic_notification,
                        Notification.PRIORITY_DEFAULT)
                .setLargeIcon(
                        BitmapFactory.decodeResource(getResources(),
                                R.drawable.ic_launcher))
                .setOngoing(true)
                .setTicker(getString(R.string.notif_ticker))
                .setContentTitle(getString(R.string.app_name))
                .setContentText(info)
                .setContentIntent(
                        PendingIntent.getActivity(this, 0, i, 0))
                .build());