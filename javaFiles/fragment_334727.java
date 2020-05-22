@Service
public ServiceOsobaImpl implementation ServiceOsoba {

    private final OsobaRepository osobaRepository;     

    @Autowired
    public ServiceOsobaImpl(OsobaRepository osobaRepository) {
        this.osobaRepository = osobaRepository;
    }

    // your methods
    ...

    public Osoba findNameById(int id) {
        String name = osobaRepository.findNameById(id);

        Osoba osoba = new Osoba();
        osoba.setName(name);

        return osoba;
    }

}