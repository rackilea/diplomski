// Create our shiro environment
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    DefaultWebEnvironment environment = new DefaultWebEnvironment();
    DefaultWebSessionManager sessionManager = new ShiroSessionManager();

    // Use the new session manager
    securityManager.setSessionManager(sessionManager);
    environment.setWebSecurityManager(securityManager);
    SecurityUtils.setSecurityManager(securityManager);