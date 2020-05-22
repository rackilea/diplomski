public class BrowseCorrelatedSessionsActivity implements MultiScrollListenerCallback {
    ...
    MultiScrollListener msl = new MultiScrollListener(this);
    ...
    public void onBrowseSessionScrolled(int someInt) {
        // handle callback
    }
}