public boolean isLoggedin(String accessToken) {
        GetUserRequest request = new GetUserRequest();
        request.withAccessToken(accessToken);

        AWSCognitoIdentityProviderClientBuilder builder = 
               AWSCognitoIdentityProviderClientBuilder.standard();
        builder.withRegion("us-west-2");
        AWSCognitoIdentityProvider cognitoCreate = builder.build();

        GetUserResult result = cognitoCreate.getUser(request);

        try {
            System.out.println("success");
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }