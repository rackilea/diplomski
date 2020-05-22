public class YourMappingService


 /**
     * Property bases mapping of roles to privileges.
     * Every role is one line, the privileges are comma separated.
     */
    private Properties roleToPrivileges;

    public YourMappingService(Properties roleToPrivileges) {
        if (roleToPrivileges == null) {
            throw new IllegalArgumentException("roleToPrivileges must not be null");
        }
        this.roleToPrivileges = roleToPrivileges;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAdditionalForRole(GrantedAuthority role) {

        String authority = role.getAuthority();
        if(authority != null) {
            String commaSeparatedPrivileges = roleToPrivileges.getProperty(role.getAuthority());
            if (commaSeparatedPrivileges != null) {
                List<GrantedAuthority> privileges = new ArrayList<GrantedAuthority>();
                for(String privilegeName : StringUtils.commaDelimitedListToSet(commaSeparatedPrivileges)) {
                    privileges.add(new GrantedAuthorityImpl(privilegeName.trim()));
                }                
                return privileges;
            } else {
                return Collections.emptyList();
            }
        } else {
            return Collections.emptyList();
        }
    }   
}