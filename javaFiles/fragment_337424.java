public class AuthProvider {
  private static final AWSCredentials credentials = new BasicAWSCredentials("key1", "");

  protected AWSCredentials obtainAuth() {
    return credentials;
  }