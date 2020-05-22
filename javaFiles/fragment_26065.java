@Entity
public class User {

    private String name;

    @ElementCollection
    @Column(name = "role")
    private List<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    public User(String name, Role... roles) {
        this.name = name;
        this.roles.addAll(asList(roles));
    }

    public enum Role {
        ROLE1, ROLE2
    }
}

@Entity
public class Order {

    private String title;

    @ManyToOne
    private User user;

    private State state;

    public enum State {
        STATE1, STATE2
    }
}

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select distinct u from User u join u.orders o join u.roles r where r = ?1 and (o.state is null or o.state = ?2)")
    List<User> getUsers(User.Role role, Order.State state);
}