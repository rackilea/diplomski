AuthenticationResultType authenticationResultType = new AuthenticationResultType();
    String idToken = authenticationResultType.getIdToken();


    // Initialize the AWS Cognito credentials provider
    credentialsProvider = new CognitoCachingCredentialsProvider(
            getApplicationContext(),
            COGNITO_POOL_ID,
            MY_REGION
    );

    Map<String, String> logins = new HashMap<String, String>();
    logins.put("yourAWSEndpoint", idToken);
    credentialsProvider.setLogins(logins);