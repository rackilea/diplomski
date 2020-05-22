public class TestBean {

    private transient final List<PropertyChangeListener> listeners = new ArrayList<PropertyChangeListener>();

    private String name;

    public void addPropertyChangeListener (PropertyChangeListener listener) {
        listeners.add(listener);
    }

    public void removePropertyChangeListener (PropertyChangeListener listener) {
        listeners.remove(listener);
    }

    private void firePropertyChange (String property, Object oldValue, Object newValue) {

        if (oldValue == newValue || oldValue != null && oldValue.equals(newValue)) {
            return;
        }

        PropertyChangeEvent evt = new PropertyChangeEvent(this, property, oldValue, newValue);
        for (PropertyChangeListener listener : new ArrayList<PropertyChangeListener>(listeners)) {
            listener.propertyChange(evt);
        }
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {

        firePropertyChange("name", this.name, this.name = name);
    }
}