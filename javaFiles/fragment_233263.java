public class CurrentUser extends User implements UserDetails {

    private final Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

    public CurrentUser(User user) {
        super(user);
        initAuthorities(user);
    }

    private void initAuthorities(User user) {
        if (user.getRoles() == null) {
            return;
        }
        for (Authority role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    // implement the rest of UserDetails interface accordingly
}