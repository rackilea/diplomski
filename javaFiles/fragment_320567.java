final int iterations = 50000;

AuthenticationToken authToken = ...;
SaltedAuthenticationInfo saltedAuthInfo = ...;

HashedCredentialsMatcher authenticator = 
     new HashedCredentialsMatcher(Sha256Hash.ALGORITHM_NAME);
authenticator.setHashIterations(iterations);

final boolean successfulAuthentication = 
     authenticator.doCredentialsMatch(authToken, saltedAuthInfo);