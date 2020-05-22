@MappedSuperclass
abstract public class User {
    @Id
    private Long id;

    private String name;

    ...
}

@Entity @Table(name = "a_user")
public class UserA extends User {}

@Entity @Table(name = "b_user")
public class UserB extends User {}