private void updateWidgetView() {
    views = new RemoteViews(YourWidget.class.getPackage().getName(),
                            R.layout.main_widget);
    mgr = AppWidgetManager.getInstance(this);
    views.setTextViewText(R.id.some_text_view, someText);
    // Tell the AppWidgetManager to perform an update on the current App Widget
    mgr.updateAppWidget(currentWidgetId, views);
}