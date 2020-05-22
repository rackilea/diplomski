public abstract class AbstractViewModel implements ViewModel {

    private EventListenerList listenerList;
    private List<String> views;

    public void addView(String name) {
        getViews().add(name);
    }

    public void removeView(String name) {
        getViews().remove(name);
    }

    @Override
    public int size() {
        return views.size();
    }

    @Override
    public String getCurrentView() {
        return getViewAt(getCurrentViewIndex());
    }

    protected abstract int getCurrentViewIndex();

    protected List<String> getViews() {
        if (views == null) {
            views = new ArrayList<>(25);
        }
        return views;
    }

    @Override
    public String getViewAt(int index) {
        return index >= 0 && index < size() ? getViews().get(index) : null;
    }

    @Override
    public void addChangeListener(ChangeListener listener) {
        getListenerList().add(ChangeListener.class, listener);
    }

    @Override
    public void removeChangeListener(ChangeListener listener) {
        getListenerList().remove(ChangeListener.class, listener);
    }

    protected EventListenerList getListenerList() {
        if (listenerList == null) {
            listenerList = new EventListenerList();
        }
        return listenerList;
    }

    protected void fireStateChanged() {
        ChangeListener[] listeners = getListenerList().getListeners(ChangeListener.class);
        if (listeners.length > 0) {
            ChangeEvent evt = new ChangeEvent(this);
            for (ChangeListener listener : listeners) {
                listener.stateChanged(evt);
            }
        }
    }    
}