@Override
public void onUpdate(Context context, AppWidgetManager appWidgetManager,
        int[] appWidgetIds) {
    // TODO Auto-generated method stub
    super.onUpdate(context, appWidgetManager, appWidgetIds);
    context.getResources().openRawResource(id);
}