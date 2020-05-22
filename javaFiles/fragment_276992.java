this.setAuthenticationManager(new OAuth2AuthenticationManager());
this.setIssuerService(new StaticSingleIssuerService());
this.setServerConfigurationService(new StaticServerConfigurationService());
this.setClientConfigurationService(new StaticClientConfigurationService());
this.setAuthRequestOptionsService(new StaticAuthRequestOptionsService());
this.setAuthRequestUrlBuilder(new PlainAuthRequestUrlBuilder());