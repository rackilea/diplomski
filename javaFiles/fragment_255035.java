Tracker t = ((MyApp) getActivity().getApplication()).getTracker(
                    TrackerName.APP_TRACKER);
t.send(new HitBuilders.EventBuilder()
 .setCategory(categoryString)
 .setAction(actionString)
 .setLabel(labelString)
 .build());