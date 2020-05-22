public class PropertyChangeBean {
    protected PropertyChangeEvent pce(String name, Object from, Object to) {
        return new PropertyChangeEvent(this, name, from, to);
    }

    private PropertyChangeSupport pcs;

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        if (pcs == null)
            pcs = new PropertyChangeSupport(this);
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        if (pcs != null)
            pcs.removePropertyChangeListener(listener);
    }

    protected void fireChange(String property, Object from, Object to) {
        if (pcs != null && !Objects.equals(from, to))
            pcs.firePropertyChange(pce(property, from, to));
    }

    protected void fireChange(String property, int from, int to) {
        if (pcs != null && from != to)
            pcs.firePropertyChange(pce(property, from, to));
    }

    protected void fireChange(String property, boolean from, boolean to) {
        if (pcs != null && from != to)
            pcs.firePropertyChange(pce(property, from, to));
    }

    protected void fireChange(PropertyChangeEvent pce) {
        if (pcs != null)
            pcs.firePropertyChange(pce);
    }
}