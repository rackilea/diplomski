import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Bean {

    private String name ;
    private final PropertyChangeSupport propertySupport ;

    public Bean(String name) {
        this.name = name ;
        this.propertySupport = new PropertyChangeSupport(this);
    }

    public Bean() {
        this("");
    }

    public String getName() {
        return name ;
    }

    public String setName(String name) {
        String oldName = this.name ;
        this.name = name ;
        propertySupport.firePropertyChange("name", oldName, name);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
}