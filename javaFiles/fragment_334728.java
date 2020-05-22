public OsobaDto implements Serializable {

    private String name;

    public OsobaDto() {}

    //getter and setter 
}


@Service
public ServiceOsobaImpl implementation ServiceOsoba {

    private final OsobaRepository osobaRepository;     

    @Autowired
    public ServiceOsobaImpl(OsobaRepository osobaRepository) {
        this.osobaRepository = osobaRepository;
    }

    // your methods
    ...

    public OsobaDto findNameById(int id) {
        String name = osobaRepository.findNameById(id);

        OsobaDto osobaDto = new OsobaDto();
        osobaDto.setName(name);

        return osobaDto;
    }

}