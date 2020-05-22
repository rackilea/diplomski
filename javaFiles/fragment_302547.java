buttonLogin.setCallback(new Callback<TwitterSession>() {
    @Override
    public void success(Result<TwitterSession> result) {
        // ... do something
    }

    @Override
    public void failure(TwitterException exception) {
        // ... do something
    }
});