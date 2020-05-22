@Component
public class ValidatorFactory {

    @Autowired
    Map<String,Validator> validators;

    public Validator getValidator(String state) {
        return validators.get(state + "Validator");
    }
}