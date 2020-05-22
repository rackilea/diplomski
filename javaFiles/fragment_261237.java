@Entity
@Table(name = "User")
public class User {
    // All user attributes

    @OneToMany
    public List<Address> addresses;

   // All getters and setters, including addresses get and set.
}

@Entity
@Table(name = "Address")
public class Address {
    // All user attributes getters/setters
}