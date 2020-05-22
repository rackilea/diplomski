@Controller
public class PersonController {

  @RequestMapping(value="/person.do", method=RequestMethod.GET)
  public ModelAndView setup() {
    ModelAndView response = new ModelAndView("person");

    //Create default bind object, can get values
    //from database if you like. Here they're just
    //hard coded.
    Person person = new Person();
    person.setName("Joe Bloggs");

    response.addObject("person", person);
    return response;
  }

  @RequestMapping(value="/person.do", method=RequestMethod.POST)
  public ModelAndView post(@ModelAttribute("person") Person person,
                           BindingResult result) {
    Validator.validate(person, result);
    if (result.hasErrors()) {
      ModelAndView response = new ModelAndView("person");
      response.addObject("person", person);
      return response;
    } else {
      personDao.store(person);
    }

    return new ModelAndView("redirect:nextPage.do");
  }

}