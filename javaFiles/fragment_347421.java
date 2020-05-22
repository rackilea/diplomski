// build the request
    AdminGetUserRequest idRequest = new AdminGetUserRequest();
    idRequest.withUserPoolId(USER_POOL_ID);
    idRequest.withUsername(username);

    // call cognito for the result
    AdminGetUserResult result = identityUserPoolProviderClient.adminGetUser(idRequest);
    // loop through results