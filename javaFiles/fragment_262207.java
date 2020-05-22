@Entity(value = "users", noClassnameStored = true)
public class User {

    public String name;

    public void save() {
        datastore().save(this);
    }

    public User query() {
        return datastore()
            .createQuery(User.class)
            .get();   
    }

}