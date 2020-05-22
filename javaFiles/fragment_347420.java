// the imported ListUsersResult is...
        import com.amazonaws.services.cognitoidp.model.ListUsersRequest;
        import com.amazonaws.services.cognitoidp.model.ListUsersResult;

             // class var

         protected final AWSCognitoIdentityProviderClient identityUserPoolProviderClient;

        // omitted stuff... 
        // initialize the Cognito Provider client.  This is used to talk to the user pool
        identityUserPoolProviderClient = new AWSCognitoIdentityProviderClient(new BasicAWSCredentials(AWS_ACCESS_KEY, AWS_SECRET_KEY)); // creds are loaded via variables that are supplied to my program dynamically
        identityUserPoolProviderClient.setRegion(RegionUtils.getRegion(USER_POOL_REGION)); // var loaded 


        // ...some code omitted        
        ListUsersRequest listUsersRequest = new ListUsersRequest();
        listUsersRequest.withUserPoolId(USER_POOL_ID); // id of the userpool, look this up in Cognito console
        listUsersRequest.withFilter("sub=xyz");  // i THINK this is how the Filter works... the documentation is terribad


    // get the results 
    ListUsersResult result = identityUserPoolProviderClient.listUsers(listUsersRequest); 

    List<UserType> userTypeList = result.getUsers();
    // loop through them
    for (UserType userType : userTypeList) {
        List<AttributeType> attributeList = userType.getAttributes();
        for (AttributeType attribute : attributeList) {
            String attName = attribute.getName();
            String attValue = attribute.getValue();
            System.out.println(attName + ": " + attValue);
        }
    }