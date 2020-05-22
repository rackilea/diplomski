package com.mycompany.myapp;

import com.mycompany.myapp.model.BaseEntity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ChangeSupportImpl implements ChangeSupport {
    // Declared transient as there is no need to serialize these fields
    private transient PropertyChangeSupport propertyChangeSupport;
    private final transient Object source;

    public ChangeSupportImpl() {
        super();
        this.source = this;
    }

    // Needed for annotation-style aspect
    public ChangeSupportImpl(final BaseEntity baseEntity) {
        super();
        this.source = baseEntity;
    }

    @Override
    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        // PropertyChangeSupport is loaded lazily
        if (this.propertyChangeSupport == null)
            this.propertyChangeSupport = new PropertyChangeSupport(this.source);
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(final PropertyChangeListener listener) {
        if (this.propertyChangeSupport != null)
            this.propertyChangeSupport.removePropertyChangeListener(listener);
    }

    @Override
    public void addPropertyChangeListener(final String propertyName, final PropertyChangeListener listener) {
        // PropertyChangeSupport is loaded lazily
        if (this.propertyChangeSupport == null)
            this.propertyChangeSupport = new PropertyChangeSupport(this.source);
        this.propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }

    @Override
    public void removePropertyChangeListener(final String propertyName, final PropertyChangeListener listener) {
        if (this.propertyChangeSupport != null)
            this.propertyChangeSupport.removePropertyChangeListener(propertyName, listener);
    }

    @Override
    public void firePropertyChange(final String propertyName, final Object oldValue, final Object newValue) {
        if (this.propertyChangeSupport != null)
            this.propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }

    @Override
    public boolean hasListeners(final String propertyName) {
        return this.propertyChangeSupport != null && (this.propertyChangeSupport.hasListeners(propertyName)
                || this.propertyChangeSupport.hasListeners(null));
    }
}