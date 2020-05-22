@Controller
public class PersonController {
    private PersonValidator personValidator;
    private PersonService personService;

    public PersonController(PersonValidator personValidator, PersonService personService) {
        this.personValidator = personValidator;
        this.personService = personService;
    }

    @RequestMapping(value = "/Person/Add", method = RequestMethod.POST)
    public ResponseEntity<String> personAdd(@Valid @RequestBody PersonRequest personRequest, Errors errors) {
        personValidator.validate(personRequest, errors);

        if (errors.hasErrors()) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        personService.add(personRequest);

        return new ResponseEntity<String>(HttpStatus.OK);
    }
}