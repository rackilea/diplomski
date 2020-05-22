import java.beans.PropertyChangeListener;
import javax.swing.event.SwingPropertyChangeSupport;

public class ShowTextModel implements MvcModel {
   private String text;
   private String status;
   private SwingPropertyChangeSupport propChangeSupport = 
         new SwingPropertyChangeSupport(this);

   @Override
   public String getText() {
      return text;
   }

   @Override
   public void setText(String text) {
      String newValue = text;
      String oldValue = this.text;
      this.text = newValue;
      propChangeSupport.firePropertyChange(TEXT, oldValue, newValue);
   }

   @Override
   public void setStatus(String status) {
      String newValue = status;
      String oldValue = this.status;
      this.status = newValue;
      propChangeSupport.firePropertyChange(STATUS, oldValue, newValue);
   }

   @Override
   public void addPropertyChangeListener(PropertyChangeListener listener) {
      propChangeSupport.addPropertyChangeListener(listener);
   }

   @Override
   public void removePropertyChangeListener(PropertyChangeListener listener) {
      propChangeSupport.removePropertyChangeListener(listener);
   }

   @Override
   public String getStatus() {
      return status;
   }

}