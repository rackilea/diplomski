public class InputMethodServiceSample extends InputMethodService {

    private Tracker mTracker;

    /**
    * Gets the default {@link Tracker} for this {@link Application}.
    * @return tracker
    */
    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }
}