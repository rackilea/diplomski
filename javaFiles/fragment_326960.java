String cognitoIdentityId = "your user's identity id";
String openIdToken = "open id token for the user created on backend";

Map<String,String> logins = new HashMap<>();
logins.put("cognito-identity.amazonaws.com", openIdToken);
GetCredentialsForIdentityRequest getCredentialsRequest =
    new GetCredentialsForIdentityRequest()
    .withIdentityId(cognitoIdentityId)
    .withLogins(logins);
AmazonCognitoIdentityClient cognitoIdentityClient = new AmazonCognitoIdentityClient();
GetCredentialsForIdentityResult getCredentialsResult = cognitoIdentityClient.getCredentialsForIdentity(getCredentialsRequest);
Credentials credentials = getCredentialsResult.getCredentials();
AWSSessionCredentials sessionCredentials = new BasicSessionCredentials(
    credentials.getAccessKeyId(),
    credentials.getSecretKey(),
    credentials.getSessionToken()
);

AmazonS3Client s3Client = new AmazonS3Client(sessionCredentials);
...