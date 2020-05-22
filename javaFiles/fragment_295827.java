@Component
public class Book {
     private String isbn;
     private String title;
     private Author author;
     // New Transient attribute to bind authorId from select component
     private String authorId;
}