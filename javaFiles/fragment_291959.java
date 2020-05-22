public class UserController extends BaseCommandController {

    private OccupationRepository occupationRepository;
    private CountryRepository countryRepository;

    // getter's and setter's (retrieved by Dependency Injection supported by Spring)

    public void setUserBindingInitializer(UserBindingInitializer bindingInitializer) {
        setWebBindingInitializer(bindingInitializer);
    }