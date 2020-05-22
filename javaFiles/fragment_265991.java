public class DataInitializer {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void populate(){
        User user = new User();
        //set user props ...
        userRepository.save(user);
    }
}