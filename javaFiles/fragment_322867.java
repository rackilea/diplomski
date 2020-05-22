class Player {
   public static final String HEALTH = "health";
   private SwingPropertyChangeSupport propChangeSupport = 
             new SwingPropertyChangeSupport(this);
   private String name;
   private int health = 100;

   public Player(String name) {
      this.name = name;
   }

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      propChangeSupport.addPropertyChangeListener(listener);
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      propChangeSupport.removePropertyChangeListener(listener);
   }

   public int getHealth() {
      return health;
   }

   public void setHealth(int health) {
      int oldValue = this.health;
      int newValue = health;
      this.health = health;
      propChangeSupport.firePropertyChange(HEALTH, oldValue, newValue);
   }

   public String getName() {
      return name;
   }

}