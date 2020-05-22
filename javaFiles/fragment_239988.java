public class FileOperation {
    private File file;
    private FileStatus status;

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public FileOperation(File file, FileStatus status) {
        this.file = file;
        this.status = status;
    }

    public FileOperation(File file) {
        this(file, FileStatus.NOT_RUN);
    }

    public File getFile() {
        return file;
    }

    public FileStatus getStatus() {
        return status;
    }

    public void setStatus(FileStatus newStatus) {
        if (status == newStatus) {
            return;
        }
        FileStatus oldStatus = status;
        status = newStatus;
        propertyChangeSupport.firePropertyChange("status", oldStatus, status);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}