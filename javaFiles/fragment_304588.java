import java.util.*;

@Component
public class PersonUpdateService {

    private final List<Field> fields;

    @Autowired
    public PersonUpdateService(final List<Field> fields) {
        this.fields = fields;
    }

    public void updatePerson(final Person person, final Map<String, String> update) {
        final boolean updated = false;
        update.forEach((key, value) -> this.findField(key).update(person, value));
    }

    private Field findField(final String index) {
        return this.fields.stream().filter(f -> f.index().equals(index)).findAny().orElseThrow(
                () -> new IllegalArgumentException("Field not found: " + index));
    }

}