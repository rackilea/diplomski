@Controller("/")
public class BooksController{

    @Autowired
    BookService bookService;

    @RequestMapping(value = "home/books", method = RequestMethod.GET)
    public ModelAndView books() {
        ModelAndView modelAndView = new ModelAndView();
        Book book = new Book("id", "name1", "author1", "54", 5);
        Book book2 = new Book("id 2", "name2", "author2", "54", 4);

        bookService.addBook(book);
        bookService.addBook(book2);

        List<Book> AllBook = bookService.getALlBooks();


        // Check here if list is empty and throw an exception

        modelAndView.addObject("books", AllBook);
        modelAndView.setViewName("books");
        return modelAndView;
    }
}