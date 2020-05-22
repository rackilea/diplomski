public class ClassWithProperty {
    private PropertyChangeSupport changes = new PropertyChangeSupport(this);
    private int usersOnline = 0;

    public ClassWithProperty() {
    }

    public void setupOnlineUsers() 
    {
        while (usersOnline < 10) {
            changes.firePropertyChange("usersOnline", usersOnline, ++usersOnline);
        }
    }

    public int getUsersOnline() {
        return usersOnline;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        changes.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        changes.removePropertyChangeListener(l);
    }
}

public class MainListener implements PropertyChangeListener {
    private ClassWithProperty test;

    public MainListener() {
        test = new ClassWithProperty();
        test.addPropertyChangeListener(this);
        test.setupOnlineUsers();
    }

    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(test.getUsersOnline());
    }

    public static void main(String[] args) {
        new MainListener(); // do everything in the constructor
    }
}