@Override
    public void onSuccess(LoginResult loginResult) {
        AccessToken accessToken = loginResult.getAccessToken();
        profile = Profile.getCurrentProfile();
        facebookListener.onFacebookLeggedIn(profile);
    }