@Entity
public class User {
    //..
    private String name;

    @OneToMany(mappedBy = "user")
    private Set<Address> addresses = new HashSet<>();
    //..
}

@Entity
public class Address {
    //..
    @ManyToOne
    private User user;
    //..
}