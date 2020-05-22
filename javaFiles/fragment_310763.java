// Get tracker.
 Tracker t = ((AnalyticsSampleApp) getActivity().getApplication()).getTracker(
    TrackerName.APP_TRACKER);
 t.setScreenName("Home Screen");

 // Send the custom dimension value with a screen view.
 // Note that the value only needs to be sent once.
 t.send(new HitBuilders.ScreenViewBuilder()
    .setCustomMetric(1, 5)
    .build()
 );