private static AuthenticationResult getAccessTokenFromServicePrincipalCredentials() throws
            ServiceUnavailableException, MalformedURLException, ExecutionException, InterruptedException {
        AuthenticationContext context;
        AuthenticationResult result = null;
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(1);
            // TODO: add your tenant id
            context = new AuthenticationContext("https://login.windows.net/" + "<your tenant id>",
                    false, service);
            // TODO: add your client id and client secret
            ClientCredential cred = new ClientCredential("<your client id>",
                    "<your client secret>");
            Future<AuthenticationResult> future = context.acquireToken(
                    "https://management.azure.com/", cred, null);
            result = future.get();
        } finally {
            service.shutdown();
        }

        if (result == null) {
            throw new ServiceUnavailableException(
                    "authentication result was null");
        }
        return result;
    }


Configuration config = ManagementConfiguration.configure(
          null,
          new URI("https://management.core.windows.net), 
          "<your-subscription-id>",
          getAccessTokenFromServicePrincipalCredentials()
.getAccessToken()
        );