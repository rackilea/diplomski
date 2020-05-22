public  class MultiScrollListener implements OnScrollListener {

    // define callback interface
    public interface MultiScrollListenerCallback {
        public void onBrowseSessionScrolled(int someInt);
    }

    public Set<OnScrollListener> children = new HashSet<OnScrollListener>();

    private MultiScrollListenerCallback multiScrollListenerCallback;

    // get a reference to the callback in the constructor
    public MultiScrollListener(MultiScrollListenerCallback multiScrollListenerCallback) {
        this.multiScrollListenerCallback = multiScrollListenerCallback;
    }


    public void addOnScrollListener(OnScrollListener listener) {
        children.add(listener);
    }
    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {

        for (OnScrollListener listener : children) {
            listener.onScrollStateChanged(absListView, i);
            // speak through the callback
            multiScrollListenerCallback.onBrowseSessionScrolled(1); 
        }
    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {

        for (OnScrollListener listener : children) {
            listener.onScroll(absListView, i, i2, i3);

        }
    }
}