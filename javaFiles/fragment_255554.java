@Validate(groups = {Second.class})
public class MachineRegistrationForm implements Validatable<List<ValidationError>> {

    @Required // Default group is Default.class
    private String field1;

    @Required(groups = {First.class})
    private String field2;

    // other fields, getters and setters

    @Override
    public List<ValidationError> validate() {

        // validation on field1 and field2

    }
}