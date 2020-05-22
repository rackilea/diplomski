@ImplementedBy(LibraryManager.class)
public interface ILibraryManager {
    //
}

@Singleton
public class LibraryManager implements ILibraryManager {

    @Inject
    private CacheApi cache;

    @Override
    public Book getBook(String isbn) {
        Book book = cache.get(isbn);
        // ...
    }

}