Notification noti = new NotificationCompat.Builder(context)
                    .setSmallIcon(icon_small)
                    .setTicker(message)
                    .setLargeIcon(largeIcon)
                    .setWhen(System.currentTimeMillis())
                    .setContentTitle(title)
                    .setContentText(message)
                    .setContentIntent(contentIntent)
                    //At most three action buttons can be added
                    .setAutoCancel(true).build();