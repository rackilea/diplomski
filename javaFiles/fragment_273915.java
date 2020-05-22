public void setLocation(Point location) {
    boolean reachedDestination;
    synchronized (this) {
        this.location = location;
        reachedDestination = location.equals(destination);
    }
    if (reachedDestination)
        dispatcher.notifyAvailable(this);
}