public synchronized void addPropertyChangeListener (PropertyChangeListener listener)  {
    if (listener == null) {
        throw new IllegalArgumentException ("Property change listener cannot be null."); //$NON-NLS-1$
    }

    myPropertyChangeDelegate.addPropertyChangeListener (listener);
}


public synchronized void removePropertyChangeListener(PropertyChangeListener listener)  {
    if (listener != null) {
        myPropertyChangeDelegate.removePropertyChangeListener (listener);
    }
}


protected void firePropertyChange(String propertyName, Object oldValue, Object newValue)  {
    if (myPropertyChangeDelegate.hasListeners (propertyName))  {
        myPropertyChangeDelegate.firePropertyChange (propertyName, oldValue, newValue);
    }
}


/** Delegate used to implement property change support. */
private transient PropertyChangeSupport myPropertyChangeDelegate;