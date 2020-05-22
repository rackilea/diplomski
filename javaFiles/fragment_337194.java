@Controller
@RequestMapping("/books")
public class BooksController {

  @RequestMapping("read")
  @Secured("ROLE_READER")
  public ModelAndView read(int id) { ... }

  @RequestMapping("canRead")
  @Secured("ROLE_READER")
  public void canRead() { }

  @RequestMapping("write")
  @Secured("ROLE_WRITER")
  public ModelAndView write(int id, String contents) { ... }

  @RequestMapping("canWrite")
  @Secured("ROLE_WRITER")
  public void canWrite() { }
}