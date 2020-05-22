CreateUserRequest user = new CreateUserRequest("userName");

CreateAccessKeyRequest key = new CreateAccessKeyRequest();

BasicAWSCredentials cred = new BasicAWSCredentials("access", "secret");

key.withUserName(user.getUserName());
key.setRequestCredentials(cred);

user.setRequestCredentials(key.getRequestCredentials());
user.setPath("/");
AmazonIdentityManagementClient client =  new AmazonIdentityManagementClient(cred);
CreateUserResult result = client.createUser(user);