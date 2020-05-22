...
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.None.class, property = "@id")
@Table(name = "t_user")
public class User implements Serializable {
...