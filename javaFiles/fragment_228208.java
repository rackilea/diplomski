// Build a new notification, which informs the user that the system
// handled their interaction with the previous notification.
Notification repliedNotification =
        new Notification.Builder(context)
            .setSmallIcon(R.drawable.ic_message)
            .setContentText(getString(R.string.replied))
            .build();

// Issue the new notification.
NotificationManager notificationManager =
    NotificationManager.from(context);
notificationManager.notify(notificationId, repliedNotification);