public static boolean authenticateJndi(String username, String password) throws Exception{
    Properties props = new Properties();
    props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
    props.put(Context.PROVIDER_URL, "ldap://LDAPSERVER:PORT");
    props.put(Context.SECURITY_PRINCIPAL, "uid=adminuser,ou=special users,o=xx.com");//adminuser - User with special priviledge, dn user
    props.put(Context.SECURITY_CREDENTIALS, "adminpassword");//dn user password


    InitialDirContext context = new InitialDirContext(props);

    SearchControls ctrls = new SearchControls();
    ctrls.setReturningAttributes(new String[] { "givenName", "sn","memberOf" });
    ctrls.setSearchScope(SearchControls.SUBTREE_SCOPE);

    NamingEnumeration<javax.naming.directory.SearchResult> answers = context.search("o=xx.com", "(uid=" + username + ")", ctrls);
    javax.naming.directory.SearchResult result = answers.nextElement();

    String user = result.getNameInNamespace();

    try {
        props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        props.put(Context.PROVIDER_URL, "ldap://LDAPSERVER:PORT");
        props.put(Context.SECURITY_PRINCIPAL, user);
        props.put(Context.SECURITY_CREDENTIALS, password);

   context = new InitialDirContext(props);
    } catch (Exception e) {
        return false;
    }
    return true;
}