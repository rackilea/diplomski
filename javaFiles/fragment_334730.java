@RestController
@RequestMapping("/api/osoba")
public class OsobaAPI {

    @Autowired
    private OsobaRepo osobaRepo;

    @JsonView(OnlyName.class)
    @PostMapping
    @RequestMapping("/getID")
    public Osoba findOsobaById(@RequestParam("id") int id){
        String name = osobaRepo.findNameById(id);
        Osoba osoba = new Osoba();
        osoba.setImie(name);
        return osoba;
    }
}