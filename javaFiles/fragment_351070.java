RemoteViews remoteViews = new RemoteViews(mContext.getPackageName(), R.layout.widget_weather);

// update appwidget remoteviews depending on state (ie which page to show)
remoteViews = populateViews(remoteViews, mState);

// set next button
Intent intent = new Intent(MYBROADCAST_NEXT);
PendingIntent pendingIntent = PendingIntent.getBroadcast(context, requestCode, intent, flags);
remoteViews.setOnClickPendingIntent(R.id.appwidget_btn_next, pendingIntent);

// set prev button
intent = new Intent(MYBROADCAST_PREV);
pendingIntent = PendingIntent.getBroadcast(context, requestCode, intent, flags);
remoteView.setOnClickPendingIntent(R.id.appwidget_btn_prev, pendingIntent);

// update the AppWidget ...