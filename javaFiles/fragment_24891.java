@RestController
@RequestMapping("/person")
public class PersonController {

    @GetMapping
    public List<Person> getPerson(){
        List<Person> persons = new ArrayList<>();

        persons.add(new Dev(1, "Java")); //Let's say I have the constructor
        persons.add(new DevOps(2, "Linux")); //Let's

        return persons;
    }
}

public class Person {
    public int id;

    public Person(int id) {
        this.id = id;
    }
}

public class Dev extends Person {
    public String lang;

    public Dev(int id, String lang) {
        super(id);
        this.lang = lang;
    }
}

public class DevOps extends Person {
    public String env;

    public DevOps(int id, String env) {
        super(id);
        this.env = env;
    }
}