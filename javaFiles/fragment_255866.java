.
.
import org.springframework.boot.CommandLineRunner;

@RestController
@RequestMapping("/api/v1")
public class BookController {

@Autowired
private BookRepository bookRepository;

public BookController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
}

@Bean
public CommandLineRunner run() throws Exception {
    return args -> {
        Book entity1 = new Book("How to stay focused", "Miriyam Bali");
        Book entity2 = new Book("Turn the World", "Cliyo Mathew");
        Book entity3 = new Book("New Heights", "Arsana Jyesh");
        Book entity4 = new Book("Create into leaves", "Nicholas A Buzaz");

        List<Book> books = Arrays.asList(entity1, entity2, entity3, entity4);
        this.bookRepository.saveAll(books);
    };
}