@Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int i = 0; i < appWidgetIds.length; i++) {
            Intent intent = new Intent(context, WidgetService.class);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds[i]);
            intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));
            RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.casus_widget);
            rv.setRemoteAdapter(appWidgetIds[i], R.id.events_list, intent);

            appWidgetManager.updateAppWidget(appWidgetIds[i], rv);
        }

        fetchData(context, appWidgetIds);

        super.onUpdate(context, appWidgetManager, appWidgetIds);

    }