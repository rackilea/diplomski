// Create an intent which triggers the fullscreen notification
Intent intent = new Intent(Intent.ACTION_MAIN, null);
intent.setAction("SELECT_NOTIFICATION");
Class mainActivityClass = getMainActivityClass(context);
intent.setClass(context, mainActivityClass);
PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);

// Build the notification as an ongoing high priority item to ensures it will show as
// a heads up notification which slides down over top of the current content.
final Notification.Builder builder = new Notification.Builder(context, CHANNEL_ID);
builder.setOngoing(true);

// Set notification content intent to take user to fullscreen UI if user taps on the
// notification body.
builder.setContentIntent(pendingIntent);

// Set full screen intent to trigger display of the fullscreen UI when the notification
// manager deems it appropriate.
builder.setFullScreenIntent(pendingIntent, true);

// Setup notification content.
int resourceId = context.getResources().getIdentifier("app_icon", "drawable", context.getPackageName());
builder.setSmallIcon(resourceId);
builder.setContentTitle("Your notification title");
builder.setContentText("Your notification content.");

MyPlugin.notificationManager().notify(someId, builder.build());