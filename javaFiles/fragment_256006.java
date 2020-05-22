public class Book {
    private static final List<Book> LIBRARY = new ArrayList<>();
    private String dewey;
    private String isbn;
    private String author;
    private String title;
    public Book(String dewey, String isbn, String author, String title) {
        this.dewey = dewey;
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        LIBRARY.add(this);
    }

    public static final List<Book> getLibrary() {
        return LIBRARY;
    }
}