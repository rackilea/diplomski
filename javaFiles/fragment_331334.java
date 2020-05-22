@Controller
public class PersonController {

    @Autowired
    private PersonService personService;


    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public @ResponseBody List<Person> listPersons_() {
        return this.personService.listPersons();
    }
...