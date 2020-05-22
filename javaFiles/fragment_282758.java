private boolean changed = false;
 private Vector obs = new Vector();

 public void notifyObservers() {notifyObservers(null);}

  public void notifyObservers(Object paramObject){
    Object[] arrayOfObject;
    synchronized (this){
      if (!(this.changed))
        return;
      arrayOfObject = this.obs.toArray();
      clearChanged();
    }
    for (int i = arrayOfObject.length - 1; i >= 0; --i)
      ((Observer)arrayOfObject[i]).update(this, paramObject);
  }