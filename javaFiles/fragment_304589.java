import java.util.regex.Pattern;

@Component
public class NameField implements Field {

    private static final String INDEX = "12";
    private static final String REGEX = "/^[A-Z][a-z0-9_-]{1,19}$/";
    private static final String CONSTRAINTS = "length min: 2, max: 20. First letter must uppercase";

    @Override
    public String index() {
        return INDEX;
    }

    @Override
    public void update(final Person person, final String newValue) {
        if (!Pattern.matches(REGEX, newValue)) {
            throw new ValidationException(CONSTRAINTS);
        }
        person.setName(newValue);
    }

}