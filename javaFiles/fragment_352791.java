protected void fireStateChanged() {
    ChangeListener[] listeners = listenerList.getListeners(ChangeListener.class);
    if (listeners != null && listeners.length > 0) {
        ChangeEvent evt = new ChangeEvent(evt);
        for (ChangeListener listener : listeners) {
            listener.stateChanged(evt);
        }
    }
}