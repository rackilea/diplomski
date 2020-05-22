public class User
{
    private Long userId;
    private String username;
    //Other fields;
    @JoinTable(name = "USER_FRIENDS", joinColumns = {
    @JoinColumn(name = "ADDING_USER", referencedColumnName = "USER_ID", nullable =   false)}, inverseJoinColumns = {
    @JoinColumn(name = "ADDED_USER", referencedColumnName = "USER_ID", nullable = false)})
    @ManyToMany
    private Collection<User> friends;

    @ManyToMany(mappedBy = "friends")
    private Collection<User> addUser;
}