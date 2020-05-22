public class User {
    @OneToOne(mappedBy = "user")
    private Status status;
    // ...
}

public class Status {
    @OneToOne
    @JoinColumn(name = "frn_user_id")
    private User user;
    // ...
}