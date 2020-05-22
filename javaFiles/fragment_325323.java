static void updateAppWidget(Context context, final AppWidgetManager appWidgetManager,
                                final int appWidgetId) {
        final RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.status_widget);
// ...

// Instantiate the RequestQueue.
       RequestQueue queue = Volley.newRequestQueue(context);
        String url ="http://stats.bytewerk.org/status.txt";
// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        if (response.equals("open")) {
                            views.setViewVisibility(R.id.status_online, 1);
                        } else {
                            views.setViewVisibility(R.id.status_offline, 1);
                        }
                        //views.setTextViewText(R.id.text, "Yeah!" + response);
                        appWidgetManager.updateAppWidget(appWidgetId, views);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                views.setViewVisibility(R.id.status_nointernet, 1);
                appWidgetManager.updateAppWidget(appWidgetId, views);

            }
        });
        queue.add(stringRequest);