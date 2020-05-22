@Configurable
public class Person {
    private IPeopleDAO _dao;

    // SNIP

    public save() {
        _dao.save(this);
    }
}

// use it like this
new Person("john", "doe").save();