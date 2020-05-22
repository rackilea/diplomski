@Bean
public ShiroFilterFactoryBean shiroFilterFactoryBean(@Value("#{ @environment['shiro.loginUrl'] ?: '/login.jsp' }") String loginUrl,
                                                     @Value("#{ @environment['shiro.successUrl'] ?: '/' }") String successUrl,
                                                     @Value("#{ @environment['shiro.unauthorizedUrl'] ?: null }") String unauthorizedUrl,
                                                     SecurityManager securityManager,
                                                     ShiroFilterChainDefinition shiroFilterChainDefinition,
                                                     Map<String, Filter> filterMap) {

    ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();

    filterFactoryBean.setLoginUrl(loginUrl);
    filterFactoryBean.setSuccessUrl(successUrl);
    filterFactoryBean.setUnauthorizedUrl(unauthorizedUrl);

    filterFactoryBean.setSecurityManager(securityManager);
    filterFactoryBean.setFilterChainDefinitionMap(shiroFilterChainDefinition.getFilterChainMap());
    filterFactoryBean.setFilters(filterMap);

    return filterFactoryBean;
}