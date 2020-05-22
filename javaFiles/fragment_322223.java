public class SecurityUser implements UserDetails{
    String ROLE_PREFIX = "ROLE_";

    String userName;
    String password;
    String role;

    public SecurityUser(String username, String password, String role){
        this.userName = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

        list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role));

        return list;
    }