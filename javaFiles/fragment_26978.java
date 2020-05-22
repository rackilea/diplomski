public class NewAwsVerifier extends AwsVerifier {
    public NewAwsVerifier(LocalVerifier wrappedVerifier) {
        super(wrappedVerifier);
    }
    ...
    @Override
    public int verify(Request request, Response response) {
    ...
        char[] userSecret = getLocalSecret(userId);
        if (userSecret == null) {
            // If there is no userSecret for the given userId then the
            // request probably specified a user that doesn't exist
            // and using that userID in the getS3Signature call
            // will result in a NullPointerException, so we intercept it here
            return RESULT_INVALID;
        }
        char[] signature = getSecret(request, response);
        String sigToCompare = AwsUtils.getS3Signature(request, userSecret);
    ...
    }
}