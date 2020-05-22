class Player2 {
    // make health a "bound property" by using property change support and listeners
    public static final String HEALTH = "health";
    public static final int MAX_HEALTH = 800;
    private SwingPropertyChangeSupport pcSupport = new SwingPropertyChangeSupport(this);
    private int health;

    public Player2() {
        this.health = MAX_HEALTH;
    }

    public int getHealth() {
        return health;
    }

    // notify all listeners if health changes
    public void setHealth(int health) {
        int oldValue = this.health;
        int newValue = health;
        this.health = health;
        pcSupport.firePropertyChange(HEALTH, oldValue, newValue);
    }

    // allow outside code to listen for changes to all bound properties
    // should also have the associated remove listener methods too
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcSupport.addPropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        pcSupport.addPropertyChangeListener(name, listener);
    }

}