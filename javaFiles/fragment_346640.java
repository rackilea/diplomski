@Component
public class CustomUserDetailsMapper extends LdapUserDetailsMapper {

@Override
public CustomUserDetails mapUserFromContext(DirContextOperations dirContextOperations, String userId, Collection<? extends GrantedAuthority> collection) {
    return new CustomUserDetails();
}
}