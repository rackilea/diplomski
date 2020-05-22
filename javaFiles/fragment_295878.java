import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class Shelf {

    // Set max number of books per shelf
    private final static int MAX_BOOKS = 6;

    // Our observable list of books
    private final ListProperty<Book> books = new SimpleListProperty<>(FXCollections.observableArrayList());

    public Shelf(List<Book> books) {
        this.books.addAll(books);
    }

    public void addBooks(Book... books) {
        this.books.addAll(books);
    }

    public static int getMaxBooks() {
        return MAX_BOOKS;
    }

    public ObservableList<Book> getBooks() {
        return books.get();
    }

    public ListProperty<Book> booksProperty() {
        return books;
    }

    public void setBooks(ObservableList<Book> books) {
        this.books.set(books);
    }
}