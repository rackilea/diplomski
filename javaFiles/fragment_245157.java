Intent updateWidgetIntent = new Intent(Context, <WIDGET_CLASS>.class);
updateWidgetIntent.setAction("android.appwidget.action.APPWIDGET_UPDATE");
// Use an array and EXTRA_APPWIDGET_IDS instead of AppWidgetManager.EXTRA_APPWIDGET_ID,
// since it seems the onUpdate() is only fired on that:
int ids[] = {mAppWidgetId};
updateWidgetIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids);
sendBroadcast(updateWidgetIntent);