AppWidgetManager manager = AppWidgetManager.getInstance(context);
    RemoteViews views = new RemoteViews(context.getPackageName(), R.name_of_your_widget_layout);
    // set text of some view
    views.setTextViewText(R.id.widget_amount_cameras, amountCameras);
    // and of another view
    views.setTextViewText(R.id.widget_location, locationCity);
    // ... and yet another view
    views.setTextViewText(R.id.locationStatus, locationStatus);

   // get IDs of widgets ,  there could be more than  one
    final int[] appWidgetIds = manager.getAppWidgetIds(new ComponentName(YOurWidgetProviderClass.class.getPackage().getName(), YOurWidgetProviderClass.class.getName()));

    // update all hte instances
    manager.updateAppWidget(appWidgetIds, views);