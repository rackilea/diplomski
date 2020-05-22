@Entity
public class Person {
    @Id
    @NotNull(groups = PersistenceGroup.class)
    private String id; //to be set by application before persistance

    private String name;
    private int age;
}

@RestController 
public class PersonController {
    @PostMapping
    public void post(Person p) {

    }
}