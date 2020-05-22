@Entity
@Table(name = "users")
@JsonSerialize(using = JsonUserSerializer.class)
public class User implements Serializable {
    // a lot of fields and getter, and setters
}