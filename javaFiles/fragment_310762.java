// Get tracker.
Tracker t = ((AnalyticsSampleApp) getActivity().getApplication()).getTracker(
    TrackerName.APP_TRACKER);
// Build and send an Event.
tracker.send(new HitBuilders.EventBuilder()
    .setCategory("Achievement")
    .setAction("Earned")
    .setLabel("5 Dragons Rescued")
    .setValue(1)
    .build());