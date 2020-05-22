cid = note.getId();
MyNotesWidgetActivity.widgetProcess = "create";

if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
    AppWidgetManager appWidgetManager = context.getSystemService(AppWidgetManager.class);

    ComponentName myProvider = new ComponentName(context, MyNotesWidget.class);
    if (appWidgetManager.isRequestPinAppWidgetSupported()) {

        Intent pinnedWidgetCallbackIntent = new Intent();

        PendingIntent successCallback = PendingIntent.getBroadcast(context, cid, pinnedWidgetCallbackIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        appWidgetManager.requestPinAppWidget(myProvider, null, successCallback);
    }
} else {
    Intent i = new Intent();
    i.setAction(Intent.ACTION_MAIN);
    i.addCategory(Intent.CATEGORY_CAR_DOCK);
    mActivity.startActivity(i);
}