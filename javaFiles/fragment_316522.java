protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
     throws AuthenticationException {
    ...
    SimplePrincipalCollection principals = new SimplePrincipalCollection(username, "jndiJdbcRealm");
    super.doClearCache(principals);

    ...
}