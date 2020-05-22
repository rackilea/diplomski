import org.my_company.my_app.domain.User

public class UserService implements UserDetailsService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        // load user
        User user = userDao.getUser(username);

        if (user != null) {

            // convert roles
            List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
            for (Privilege p : user.getPrivileges()) {
                roles.add(new GrantedAuthorityImpl(p.getName()));
            }

            // initialize user
            SecurityUser securityUser = new SecurityUser(
                user.getUsername(),
                user.getLdapAuth() ? getLdapPassword(user.getUsername()) : user.getPassword(),
                user.getStatus() != User.Status.NOT_COMMITED, user.getStatus() != User.Status.BLOCKED, true, true,
                roles.toArray(new GrantedAuthority[0])
            );

            securityUser.setUser(user);

            return securityUser;
        } else {
            throw new UsernameNotFoundException("No user with username '" + username + "' found!");
        }
    }
}