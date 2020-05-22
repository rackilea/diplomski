public class SelecterModel {
    public static final String SELECTED_PROPERTY = "selected";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private boolean selected;

    public boolean isSelected() {
        return selected;
    }

    public boolean setSelected(boolena selected) {
        boolean old = this.selected;
        this.selected = selected;
        support.firePropertyChange(SELECTED_PROPERTY, old, selected);
    }

    public void addSelectionChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(SELECTED_PROPERTY, pcl);
    }

    public void removeSelectionChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(SELECTED_PROPERTY, pcl);
    }
}