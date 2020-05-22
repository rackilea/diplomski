String PerformSRPAuthentication(String username, String password) {
    String authresult = null;

    InitiateAuthRequest initiateAuthRequest = initiateUserSrpAuthRequest(username);
    try {
        AnonymousAWSCredentials awsCreds = new AnonymousAWSCredentials();
        AWSCognitoIdentityProvider cognitoIdentityProvider = AWSCognitoIdentityProviderClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .withRegion(Regions.fromName(this.region))
                .build();
        InitiateAuthResult initiateAuthResult = cognitoIdentityProvider.initiateAuth(initiateAuthRequest);
        if (ChallengeNameType.PASSWORD_VERIFIER.toString().equals(initiateAuthResult.getChallengeName())) {
            RespondToAuthChallengeRequest challengeRequest = userSrpAuthRequest(initiateAuthResult, password);
            RespondToAuthChallengeResult result = cognitoIdentityProvider.respondToAuthChallenge(challengeRequest);
            //System.out.println(result);
            System.out.println(CognitoJWTParser.getPayload(result.getAuthenticationResult().getIdToken()));
            authresult = result.getAuthenticationResult().getIdToken();
        }
    } catch (final Exception ex) {
        System.out.println("Exception" + ex);

    }
    return authresult;
}


 private InitiateAuthRequest initiateUserSrpAuthRequest(String username) {

    InitiateAuthRequest initiateAuthRequest = new InitiateAuthRequest();
    initiateAuthRequest.setAuthFlow(AuthFlowType.USER_SRP_AUTH);
    initiateAuthRequest.setClientId(this.clientId);
    //Only to be used if the pool contains the secret key.
    //initiateAuthRequest.addAuthParametersEntry("SECRET_HASH", this.calculateSecretHash(this.clientId,this.secretKey,username));
    initiateAuthRequest.addAuthParametersEntry("USERNAME", username);
    initiateAuthRequest.addAuthParametersEntry("SRP_A", this.getA().toString(16));
    return initiateAuthRequest;
}