import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class User extends Model {

    @Id
    public String email;
    public String name;

    @JsonIgnore
    public String password;
    ...
}