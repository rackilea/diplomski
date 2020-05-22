@Service
class PersonService {
    @Autowired
    public PersonService(Person person) {
        this.person = person; //the object the service can work with
    }
}