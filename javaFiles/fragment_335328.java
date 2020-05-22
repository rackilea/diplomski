import java.beans.*;
import java.io.Serializable;

public class ModelBean implements Serializable {

    private boolean checked;

    private PropertyChangeSupport propertySupport;

    public ModelBean() {
        propertySupport = new PropertyChangeSupport(this);
    }

    public boolean getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        boolean oldValue = this.checked;
        this.checked = checked;
        propertySupport.firePropertyChange("checked", oldValue, this.checked);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }  
}