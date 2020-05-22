import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.ImageView;

public class Book {

    private final StringProperty title = new SimpleStringProperty();
    private final ObjectProperty<ImageView> coverImage = new SimpleObjectProperty<>();

    public Book(String title, ImageView coverImage) {
        this.title.set(title);
        this.coverImage.set(coverImage);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public ImageView getCoverImage() {
        return coverImage.get();
    }

    public ObjectProperty<ImageView> coverImageProperty() {
        return coverImage;
    }

    public void setCoverImage(ImageView coverImage) {
        this.coverImage.set(coverImage);
    }
}