public class UserAvatar {
    ...

    @ManyToOne
    @JoinColumn(name="userId") // userId is the name of your database FK column
    private User user;

    ...
}

public class User {
    ...

    @OneToMany(mappedBy="user")
    public List<UserAvatar> avatars;

    ...
}