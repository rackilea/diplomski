public class ServerManager implements Runnable {
  public static final String IS_RUNNING = "is running"; // for the Event's name
  private SwingPropertyChangeSupport propChngSupport = new SwingPropertyChangeSupport(this);
  private volatile boolean isRunning  = false;
  // other variables

  // addPropertyChangeListener(...) {...} goes here
  // removePropertyChangeListener(...)  {...} goes here

  public void setIsRunning(boolean isRunning) {
    boolean newValue = isRunning;
    boolean oldValue = this.isRunning;
    this.isRunning = isRunning;
    propChngSupport.firePropertyChange(IS_RUNNING, oldValue, newValue);    
  }

  public void run() {
    // ....
  }

  // other methods
}