FirebaseAuth.AuthStateListener mAuthStateListener = new FirebaseAuth.AuthStateListener() {
    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        showToast("2");
        Authenticate(edtUsernameLoginPage, edtPasswordLoginPage, txtErrorLoginPage);
    }
    showToast("14")
};
FirebaseAuth.getInstance().addAuthStateListener(mAuthStateListener);