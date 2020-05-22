import java.util.ArrayList;

import java.util.List;

public class Book {

    private String isbn;
    private String title;
    private String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return author + ": " + title;
    }

    public boolean equals(Object x){
        if (x instanceof Book){
            return isbn.equals(((Book) x).isbn);
        } else {
            return false;
        }
    }

}