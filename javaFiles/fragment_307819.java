@Service
public class PhoneService {

    private List<Phone> phones;

    @Autowired
    private PhoneRepository phoneRepository;

    public List<Phone> getAllPhones(){
        return phones;
    }

    public Phone getPhone(final Long id){
        return phoneRepository.findById(id);
    }

    public void addPhone(Phone phone) {
        phones.add(phone);
        phoneRepository.save(phone);
    }

    @PostConstruct
    private void initDataForTesting() {

        phones = new ArrayList<Phone>();

        Phone phone1 = new Phone((long) 1,"nokia");
        Phone phone2 = new Phone((long) 2,"sony");
        Phone phone3 = new Phone((long) 3,"samsung");

        phones.add(phone1);
        phones.add(phone2);
        phones.add(phone3);
        phoneRepository.save(phones);
    }

}