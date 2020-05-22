@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService
{

private static List<UserObject> users = new ArrayList();

public UserDetailsServiceImpl() {
    //in a real application, instead of using local data,
    // we will find user details by some other means e.g. from an external system
    users.add(new UserObject("ali", "123", "USER"));
    users.add(new UserObject("reza", "234", "USER"));
}

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<UserObject> user = users.stream()
            .filter(u -> u.name.equals(username))
            .findAny();
    if (!user.isPresent()) {
        throw new UsernameNotFoundException("User not found by name: " + username);
    }
    return toUserDetails(user.get());
}

private UserDetails toUserDetails(UserObject userObject) {
    return User.withUsername(userObject.name)
            .password(userObject.password)
            .roles(userObject.role).build();
}

private static class UserObject {
    private String name;
    private String password;
    private String role;

    public UserObject(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }
}
}