@Controller
@SessionAttributes("person")
public class YourController {
...
  @ModelAttribute("person")
  public Person getPerson() {
      return new Person();
  }

  @RequestMapping("editPerson")
  public void editPerson (@ModelAttribute("person") Person person) {
    person = dao.getThatPerson ();
  }

  @RequestMapping(value="postperson", method = RequestMethod.POST)
  public void postPerson(@ModelAttribute("person") Person person) {
    // do stuff with person
  }
}