@Service
public class BookServiceImpl implements BookService {

    @Autowired
    Bookrepository bookrepository;

    @Override
    public List<Book> getALlBooks() {

        return bookrepository.findAll();
    }

    @Override
    public void addBook(Book book) {

        bookrepository.save(book);
    }

}