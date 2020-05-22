package hello;

public interface BookRepository {
    //originally it returned {@link hello.Book}
    String getByIsbn(String isbn);
}