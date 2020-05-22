@Entity
public class User extends Model{

    @Id
    public Long id;
    public String name;

    public static Finder<Long,User> find = new Finder<Long,User>(Long.class, User.class);

}