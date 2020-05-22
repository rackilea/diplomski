@Controller
public class ListBooksController {

  @Autowired
  ListOfBooks listOfBooks;

  @RequestMapping("/addBooks")
  public String addBooks() {
    listOfBooks.addBooks();
    return "books";
  }

  @RequestMapping("/books")
  public String books(Model model) {
    model.addAttribute("books", listOfBooks.listBooks());
    return "books";
  }

}