@Entity
public class User {
    @Id public Long id;

    @Index public String name;
    @Index public String email;
    // other properties...
}