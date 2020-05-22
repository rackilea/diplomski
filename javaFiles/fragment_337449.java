protected void fireStateChanged() {
    ChangeListener[] listeners = getListenerList().getListeners(ChangeListener.class);
    if (listeners.length > 0) {
        ChangeEvent evt = new ChangeEvent(this);
        for (ChangeListener listener : listeners) {
            listener.stateChanged(evt);
        }
    }
}