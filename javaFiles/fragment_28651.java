@Entity
public class User extends Model {

    @Basic(optional=false) @Column(unique=true) public String name;

    public User(String name) {
        this.name = name;
        create();
    }

    /** used in registration to find name clash */
    public static User findByName(String name) {
        return find("name", name).first();
    }

}