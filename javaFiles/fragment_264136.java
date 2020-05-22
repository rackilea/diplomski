public class WidgetProvider extends AppWidgetProvider {

 public static final String REFRESH_ACTION = "com.packagename.REFRESH_ACTION";

@Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

   if (intent.getAction().equals(WidgetProvider.REFRESH_ACTION)) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            int[] appWidgetIds = extras.getIntArray(AppWidgetManager.EXTRA_APPWIDGET_IDS);

            if (appWidgetIds != null && appWidgetIds.length > 0) {
                Toast.makeText(context, "REFRESH", Toast.LENGTH_SHORT).show();
                this.onUpdate(context, AppWidgetManager.getInstance(context), appWidgetIds);
            }
        }
    }

}


@Override
public void onUpdate(final Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
    final int N = appWidgetIds.length;


    for (int i = 0; i < N; ++i) {

        RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.widget_layout);

        Intent intentServiceCall = new Intent(context, WidgetService.class);
        intentServiceCall.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds[i]);

     //Refresh
        Intent refreshIntent = new Intent(context, WidgetProvider.class);
        refreshIntent.setAction(WidgetProvider.REFRESH_ACTION);
        refreshIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
        intentServiceCall.setData(Uri.parse(intentServiceCall.toUri(Intent.URI_INTENT_SCHEME)));
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, refreshIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        rv.setOnClickPendingIntent(R.id.ivRefreshWidget, pendingIntent);

  appWidgetManager.updateAppWidget(appWidgetIds[i], rv);
    }
    super.onUpdate(context, appWidgetManager, appWidgetIds);
}