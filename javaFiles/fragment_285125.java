private final PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

private int progress;

public void addPropertyChangeListener(PropertyChangeListener listener)
{
    changeSupport.addPropertyChangeListener(listener);
}

public void removePropertyChangeListener(PropertyChangeListener listener)
{
    changeSupport.removePropertyChangeListener(listener);
}

public int getProgress()
{
    return progress;
}

public static final String PROPERTY_PROGRESS = "progress";

public void setProgress(int progress)
{
    int old = this.progress;
    this.progress = progress;
    changeSupport.firePropertyChange(PROPERTY_PROGRESS, old, progress);
}