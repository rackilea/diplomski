import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Movie implements Serializable {

    private transient StringProperty title = new SimpleStringProperty();
    private transient StringProperty director = new SimpleStringProperty();

    public Movie() {

    }

    public Movie(String title, String director) {
        setTitle(title);
        setDirector(director);
    }



    @Override
    public int hashCode() {
        return Objects.hash(getDirector(), getTitle());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Movie other = (Movie) obj;
        return Objects.equals(getTitle(), other.getTitle()) 
                && Objects.equals(getDirector(), other.getDirector());

    }

    public final StringProperty titleProperty() {
        return this.title;
    }

    public final String getTitle() {
        return this.titleProperty().get();
    }

    public final void setTitle(final String title) {
        this.titleProperty().set(title);
    }

    public final StringProperty directorProperty() {
        return this.director;
    }

    public final String getDirector() {
        return this.directorProperty().get();
    }

    public final void setDirector(final String director) {
        this.directorProperty().set(director);
    }

    private void readObject(ObjectInputStream s) throws ClassNotFoundException, IOException {
        s.defaultReadObject();
        title = new SimpleStringProperty((String) s.readObject());
        director = new SimpleStringProperty((String) s.readObject());
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeObject(getTitle());
        s.writeObject(getDirector());
    }

}