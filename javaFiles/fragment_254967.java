LdapAuthenticationToken extends AuthenticationToken {
    String getOrganizationalUnit();
}

LdapUsernamePasswordToken extends UsernamePasswordToken 
    implements LdapAuthenticationToken  {
    private String organizationalUnit; //add getter/setter
}

MyLdapRealm extends LdapRealm {
    private String organizationalUnit; //add getter/setter
    @Override
    public boolean supports(AuthenticationToken token) {
        return token != null && token instanceof LdapAuthenticationToken &&
            this.organizationalUnit.equals(
                ((LdapAuthenticationToken)token).getOrganizationalUnit());
    }

    @Override
    protected AuthenticationInfo doGetAuthenticatinoInfo(AuthenticationToken token) {
        LdapAuthenticationToken ldapToken = (LdapAuthenticationToken)token;
        //get the OU here, and do whatever you want with it.
    }
}