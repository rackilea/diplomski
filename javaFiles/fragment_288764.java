AccessToken token = ParseFacebookUtils.getController().getCurrentAccessToken();

if (token != null && !token.isExpired())
{
    // the user is logged-in with valid tocken
}