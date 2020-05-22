AccessTokenPair reAuthTokens = mDBApi.getSession().getAccessTokenPair();

if (reAuthTokens == null) {
    reAuthTokens = new AccessTokenPair(...);
    mDBApi.getSession().setAccessTokenPair(reAuthTokens);
}