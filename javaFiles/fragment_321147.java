@Component
public UserService {
    private List<Customer> registeredCustomers;
    // ...

    @PostConstruct
    public void loadPreviouslyRegisteredUsers() {
        registeredCustomers = loadFile();
    }
}