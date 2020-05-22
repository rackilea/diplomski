class DelegatingService {
    @Autowired
    private List<IPersonService> personServices;

    private Map<PersonType, IPersonService> personServiceMap;

    @PostConstruct
    public void init() {
        personServiceMap = new HashMap<>();
        for (IPersonService personService : personServices) {
            personServiceMap.put(personService.supportedPersonType(), personService);
        }
    }

    public void delegate(PersonType mode) {
        personServiceMap.get(mode).run();
    }
}