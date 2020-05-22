import java.beans.PropertyChangeListener;

public interface MvcModel {
   static final String TEXT = "text";
   static final String STATUS = "STATUS";

   String getText();

   String getStatus();

   void setText(String text);

   void setStatus(String text);

   void addPropertyChangeListener(PropertyChangeListener listener);

   void removePropertyChangeListener(PropertyChangeListener listener);
}