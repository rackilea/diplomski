package com.mycompany.myapp;

import java.beans.PropertyChangeListener;

public interface ChangeSupport {
    // Add listener for all properties
    public void addPropertyChangeListener(PropertyChangeListener listener);
    // Remove listener for all properties
    public void removePropertyChangeListener(PropertyChangeListener listener);
    // Add listener for specific property
    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener);
    // Remove listener for specific property
    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener);
    // Fire change event for specific property
    public void firePropertyChange(String propertyName, Object oldValue, Object newValue);
    // Check if property has any listeners attached
    public boolean hasListeners(String propertyName);
}