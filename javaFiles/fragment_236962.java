// Initialize the OAuth2 Library
    OAuth2Auth oauth2 = OAuth2Auth.createKeycloak(vertx, OAuth2FlowType.PASSWORD, keycloakJson);

    // first get a token (authenticate)
    oauth2.getToken(new JsonObject().put("username", "user").put("password", "secret"), res -> {
      if (res.failed()) {
        // error handling...
      } else {
        AccessToken token = res.result();

        // now check for permissions
        token.isAuthorised("account:manage-account", r -> {
          if (r.result()) {
            // this user is authorized to manage its account
          }
        });
      }
});