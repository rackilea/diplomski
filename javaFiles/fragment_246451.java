RemoteViews newNotifContent = new RemoteViews(getPackageName(), R.layout.custom_notification);
    newNotifContent.setTextViewText(R.id.exerciseName, _currentExercise.getTitle());
    newNotifContent.setTextViewText(R.id.setNumber, getString(R.string.sets_prefix, _currentSet, _currentExercise.getSets()));
    newNotifContent.setTextViewText(R.id.timeElapsed, getFormattedElapsedTime());

    Notification notif = mBuilder.build();
    notif.bigContentView = newNotifContent;

    mNotificationManager.notify(NOTIFICATION_ID,notif);