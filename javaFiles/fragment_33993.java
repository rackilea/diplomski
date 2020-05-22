@Override
public UserDetails mapUserFromContext(DirContextOperations ctx, String username, Collection<? extends GrantedAuthority> authorities) 
{

    Attributes attributes = ctx.getAttributes();
    Object[] groups = new Object[100];
    groups = ctx.getObjectAttributes("memberOf");

    LOGGER.debug("Attributes: {}", attributes);

    Set<GrantedAuthority> authority = new HashSet<GrantedAuthority>();

    for(Object group: groups)
    {

        if (group.toString().toLowerCase().contains("AD_GROUP_NAME".toLowerCase()) == true)
        {
            authority.add(new SimpleGrantedAuthority("ROLE_USER"));
            break;          
        }
    }

    User userDetails = new User(username, "", false, false, false, false, authority);
    return userDetails;
}