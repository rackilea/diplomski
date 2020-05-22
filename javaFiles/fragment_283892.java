@Entity
public class Genre {
    // fields and methods

    @Override 
    public String toString() {
        return this.name;
    }
}

// in your GUI
List<Genre> genres = findAllGenresSortedByName();
this.cbGenre = new JComboBox(genres.toArray());
// ...
Genre selectedGenre = (Genre) this.cbGenre.getSelectedItem();