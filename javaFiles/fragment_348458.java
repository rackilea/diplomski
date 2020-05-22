AppWidgetManager mAppWidgetManager =
context.getSystemService(AppWidgetManager.class);

AppWidgetProviderInfo myWidgetProviderInfo = new AppWidgetProviderInfo();
ComponentName myProvider = myWidgetProviderInfo.provider;

if (mAppWidgetManager.isRequestPinAppWidgetSupported()) {
  // Create the PendingIntent object only if your app needs to be notified
  // that the user allowed the widget to be pinned. Note that, if the pinning
  // operation fails, your app isn't notified.
  Intent pinnedWidgetCallbackIntent = new Intent( ... );

  // Configure the intent so that your app's broadcast receiver gets
  // the callback successfully. This callback receives the ID of the
  // newly-pinned widget (EXTRA_APPWIDGET_ID).
  PendingIntent successCallback = PendingIntent.createBroadcast(context, 0,
          pinnedWidgetCallbackIntent);

  mAppWidgetManager.requestPinAppWidget(myProvider, null,
           successCallback.getIntentSender());
}