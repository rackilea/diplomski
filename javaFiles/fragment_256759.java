import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Movie {

    private String title ;
    private String director ;
    private final PropertyChangeSupport propertySupport ;

    public Movie(String title, String director) {
        this.title = title ;
        this.director = director ;
        this.propertySupport = new PropertyChangeSupport(this);
    }

    public Movie() {
        this("", "");
    }

    public String getTitle() {
        return title ;
    }

    public String setTitle(String title) {
        String oldTitle = this.title ;
        this.title = title ;
        propertySupport.firePropertyChange("title", oldTitle, title);
    }

    // similarly for director...

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    // hashCode and equals...
}