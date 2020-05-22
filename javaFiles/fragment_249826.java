// Set up the MediaContract object to call into the Media Services account
  Configuration configuration = MediaConfiguration.configureWithOAuthAuthentication(
                    mediaServiceUri, oAuthUri, clientId, clientSecret, scope);
  configuration.getProperties().put(Configuration.PROPERTY_HTTP_PROXY_HOST, "Hostvalue");
  configuration.getProperties().put(Configuration.PROPERTY_HTTP_PROXY_PORT, "Portvalue");
  configuration.getProperties().put(Configuration.PROPERTY_HTTP_PROXY_SCHEME, "http");
  MediaContract mediaService = MediaService.create(configuration);