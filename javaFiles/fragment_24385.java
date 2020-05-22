@Autowired
private List<IPersonService> personServices;

public void delegate(PersonType mode) {
    for (IPersonService personService : personServices) {
        if (personService.supportedPersonType().equals(mode)) {
            personService.run();
            break;
        }
    }
}