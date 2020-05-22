for (int widgetId : allWidgetIds) {
            RemoteViews remoteViews = new RemoteViews(this.getApplicationContext().getPackageName(), R.layout.casus_widget);


            Intent svcIntent = new Intent(this.getApplicationContext(), WidgetService.class);
            svcIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId);
            svcIntent.putExtra("events", events);
            svcIntent.setData(Uri.parse(svcIntent.toUri(Intent.URI_INTENT_SCHEME)));
            remoteViews.setRemoteAdapter(widgetId, R.id.events_list, svcIntent);


            Intent clickIntent = new Intent(this.getApplicationContext(), CasusWidgetProvider.class);
            clickIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, allWidgetIds);
            clickIntent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));
            clickIntent.setAction(CasusWidgetProvider.ITEM_CLICK);


            PendingIntent toastPendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 0, clickIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            remoteViews.setPendingIntentTemplate(R.id.events_list, toastPendingIntent);

            appWidgetManager.updateAppWidget(widgetId, remoteViews);

        }