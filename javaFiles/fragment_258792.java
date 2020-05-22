@Bean(name = "shiroFilter")
public AbstractShiroFilter shiroFilter() throws Exception {
    ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
    Map<String, String> filterChainDefinitionMapping = new HashMap<>();
    filterChainDefinitionMapping.put("/api/health", "authc,roles[guest],ssl[8443]");
    filterChainDefinitionMapping.put("/login", "authc");
    filterChainDefinitionMapping.put("/logout", "logout");
    shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMapping);
    shiroFilter.setSecurityManager(securityManager());
    shiroFilter.setLoginUrl("/login");
    Map<String, Filter> filters = new HashMap<>();
    filters.put("anon", new AnonymousFilter());
    filters.put("authc", new FormAuthenticationFilter());
    LogoutFilter logoutFilter = new LogoutFilter();
    logoutFilter.setRedirectUrl("/login?logout");
    filters.put("logout", logoutFilter);
    filters.put("roles", new RolesAuthorizationFilter());
    filters.put("user", new UserFilter());
    shiroFilter.setFilters(filters);
    return (AbstractShiroFilter) shiroFilter.getObject();
}