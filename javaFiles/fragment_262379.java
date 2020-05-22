public interface Progressable {
    public void addPropertyChangeListener(PropertyChangeListener listener);
    public void removePropertyChangeListener(PropertyChangeListener listener);
    public void setInProgress(boolean inProgress);
    public boolean isInProgress();
}