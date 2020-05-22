public class LocationWidget extends AppWidgetProvider {
    public static String WIDGET_BUTTON = "MY_PACKAGE_NAME.WIDGET_BUTTON";

    private static final String ACTION_CLICK = "ACTION_CLICK";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int count = appWidgetIds.length;
        String status;
        LocationManager manager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        for (int i = 0; i < count; i++) {
            int widgetId = appWidgetIds[i];
            if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                status = "OFF";
            } else {
                status = "ON";
            }
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.activity_main);


            if (status == "ON") {
                remoteViews.setInt(R.id.actionButton, "setBackgroundColor", Color.GREEN);
                remoteViews.setTextViewText(R.id.actionButton, "Location Service On");
            }
            if (status == "OFF") {
                remoteViews.setInt(R.id.actionButton, "setBackgroundColor", Color.RED);
                remoteViews.setTextViewText(R.id.actionButton, "Location Service Off");
            }
            Intent intent = new Intent(context, LocationWidget.class);
            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

            String buttonclick = "buttonclick";

            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            remoteViews.setOnClickPendingIntent(R.id.actionButton, getPendingSelfIntent(context, buttonclick));

            appWidgetManager.updateAppWidget(widgetId, remoteViews);
        }
    }

    protected PendingIntent getPendingSelfIntent(Context context, String action) {
        Intent intent = new Intent(context, LocationWidget.class);
        intent.setAction(action);
        return PendingIntent.getBroadcast(context, 0, intent, 0);
    }

    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.activity_main);


        if (intent.getAction() == "buttonclick") {
            Log.v("ACTION", "buttonclick");

            Intent callGPSSettingIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            callGPSSettingIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(callGPSSettingIntent);


        }


    }




}