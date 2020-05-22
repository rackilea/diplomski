@GetMapping
@JsonView(User.Activity.class)
public User getUser() {
    User user = new User();
    return user;
}