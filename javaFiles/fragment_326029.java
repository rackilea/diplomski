@Component
public class SimpleBookRepository implements BookRepository {
    @Autowired
    private transient SimpleCache cache;

    @Override
    public String getByIsbn(String isbn) {
       return cache.getMap().get(isbn);
    }

}