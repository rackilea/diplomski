/** Time to wait */
private final int DELAY = 1000;
/** Waiting timer */
private javax.swing.Timer waitingTimer;

/**
 * Handle resize event.
 */
public void componentResized(ComponentEvent e) 
{
  if (this.waitingTimer==null)
  {
    /* Start waiting for DELAY to elapse. */
    this.waitingTimer = new Timer(DELAY,this);
    this.waitingTimer.start();
  }
  else
  {
    /* Event came too soon, swallow it by resetting the timer.. */
    this.waitingTimer.restart();
  }
}

/** 
 * Actual resize method
 */
public void applyResize()
{
  //...
}

/**
 * Handle waitingTimer event 
 */
public void actionPerformed(ActionEvent ae)
{
  /* Timer finished? */
  if (ae.getSource()==this.waitingTimer)
  {
    /* Stop timer */
    this.waitingTimer.stop();
    this.waitingTimer = null;
    /* Resize */
    this.applyResize();
  }
}