@SuppressWarnings("deprecation")
@Override
public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException, DataAccessException
{
    System.out.println("Getting access details from employee dao !!");

    // Ideally it should be fetched from database and populated instance of
    // #org.springframework.security.core.userdetails.User should be returned from this method
    UserDetails user = new User(username, "password", true, true, true, true, new GrantedAuthority[]{ new GrantedAuthorityImpl("ROLE_USER") });
    return user;
}