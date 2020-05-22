/** authentication config */
CachingAuthenticator<BasicCredentials, AuthUser> cachingAuthenticator = new CachingAuthenticator<>(
    environment.metrics(), new MyAuthenticator(), configuration.getAuthenticationCachePolicy());

environment.jersey().register(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<AuthUser>()
    .setAuthenticator(cachingAuthenticator).setRealm("kedar.javalkar.realm").buildAuthFilter()));

environment.jersey().register(new AuthValueFactoryProvider.Binder<>(AuthUser.class));