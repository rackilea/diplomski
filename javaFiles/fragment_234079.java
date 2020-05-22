import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.event.SwingPropertyChangeSupport;

public class Foo {
   public static final String MY_BOUND_PROPERTY = "My Bound Property";
   private SwingPropertyChangeSupport spcSupport = new SwingPropertyChangeSupport(
         this);
   private String myBoundProperty;

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      spcSupport.addPropertyChangeListener(listener);
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      spcSupport.removePropertyChangeListener(listener);
   }

   public String getMyBoundProperty() {
      return myBoundProperty;
   }

   public void setMyBoundProperty(String myBoundProperty) {
      Object oldValue = this.myBoundProperty;
      Object newValue = myBoundProperty;

      this.myBoundProperty = myBoundProperty;
      PropertyChangeEvent pcEvent = new PropertyChangeEvent(this,
            MY_BOUND_PROPERTY, oldValue, newValue);
      spcSupport.firePropertyChange(pcEvent);
   }

}