class Gamma {
   public static final String X = "x";
   private PropertyChangeSupport support = new PropertyChangeSupport(this);

   private int x = 10;

   public int getX() {
      return x;
   }

   public void setX(int x) {
      int oldValue = x;
      int newValue = this.x;
      this.x = x;
      support.firePropertyChange(X, oldValue, newValue);
   }

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      support.addPropertyChangeListener(listener);
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      support.removePropertyChangeListener(listener);
   }
}