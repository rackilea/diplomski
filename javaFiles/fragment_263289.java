import java.beans.PropertyChangeListener;
import javax.swing.event.SwingPropertyChangeSupport;

public class Model {
   public static final String SCORE = "score";
   public static final String LEVEL = "level";
   private SwingPropertyChangeSupport pcSupport = 
         new SwingPropertyChangeSupport(this);
   private int score;
   private int level;

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.addPropertyChangeListener(listener);
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.removePropertyChangeListener(listener);
   }

   public int getScore() {
      return score;
   }

   public void setScore(int score) {
      int oldValue = this.score;
      int newValue = score;

      this.score = score;
      pcSupport.firePropertyChange(SCORE, oldValue, newValue);
   }

   public int getLevel() {
      return level;
   }

   public void setLevel(int level) {
      int oldValue = this.level;
      int newValue = level;

      this.level = level;
      pcSupport.firePropertyChange(LEVEL, oldValue, newValue);
   }

}