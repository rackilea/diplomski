@Controller
public class ListBooksController {

  @Autowired
  ListOfBooks listOfBooks;

  @RequestMapping("/books")
  public String books(Model model) {
    if(listOfBooks.listBooks().isEmpty())
         listOfBooks.addBooks();
    model.addAttribute("books", listOfBooks.listBooks());
    return "books";
  }

}