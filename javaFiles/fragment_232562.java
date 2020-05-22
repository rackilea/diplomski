@Override
public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
    super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
    try {
            //open selection
            Intent intn = new Intent (context, DialogSelect.class);
            intn.setFlags (Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intn);
    } catch (Exception e) {Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();}
    updateAppWidget(context, appWidgetManager, appWidgetId);
}