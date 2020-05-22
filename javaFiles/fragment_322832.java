public interface PersonDao {
    void store(Person personToStore);
    Person findById(String id);
}

public class SqlPersonDao implements PersonDao {
    @Override
    void store(Person personToStore) {
        // use database connection here ...
    }
}