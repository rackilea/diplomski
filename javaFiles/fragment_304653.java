fbSignInButton.addListener(new ClickListener() {
    @Override
    public void clicked() {
        facebookApi.signIn();
    }
});