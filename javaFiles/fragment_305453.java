public static final Collection<String> YOUTUBE_SCOPE = Arrays.asList("https://www.googleapis.com/auth/youtube.force-ssl https://www.googleapis.com/auth/youtubepartner");

...

private void handleSignInResult(GoogleSignInResult result) {

    ...

    GoogleAccountCredential credential = GoogleAccountCredential.usingOAuth2(context, YOUTUBE_SCOPE);
    credential.setSelectedAccount(acct.getAccount());

    ...

}