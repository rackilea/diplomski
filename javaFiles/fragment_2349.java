public boolean isLoggedIn() {
if (isFreshAccessToken())
    return true;

// If the access token is expired, we'll need to use the
// refresh token to get another one.  Use a background task
// to do this.
String refreshToken = preferences.getString(REFRESH_TOKEN_KEY, null);
if (StringUtils.isNotBlank(refreshToken)) {
    Callback callback = new Callback() {
        public void done(boolean result){
            // whatever you need to do here
        }
    }
    RefreshAccessTokenAsyncTask refreshLogin = new RefreshAccessTokenAsyncTask(callback);
    refreshLogin.execute(refreshToken);
} else
    return false;
}