void configureAuthentication(Environment environment) {
  JdbcRealm realm = getJdbcRealm(); // However your Shiro realm is configured

  DefaultSecurityManager securityManager = new DefaultSecurityManager(realm);
  SecurityUtils.setSecurityManager(securityManager);

  environment.jersey().register(new BasicAuthProvider<Subject>(new BasicAuthenticator(), "Shiro"));
}