public class AppAuthProvider implements AuthenticationProvider {

    private static final String PERMISSION_PREFIX = "ROLE_PERMISSION_";
    // get the logging user info

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {


        Collection<GrantedAuthority> permissions = new HashSet<GrantedAuthority>();
        for (Role role : user.getRole()) {
            for (Permission perm : role.getPermissions()) {
                GrantedAuthority permission = new SimpleGrantedAuthority(PERMISSION_PREFIX + perm.getPermissionName());
                permissions.add(permission);
            }
        }

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user, null, permissions); // user object you get from service/repository

        return authToken;
    }
}