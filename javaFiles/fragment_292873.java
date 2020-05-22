private void updateViewWithGoogleSignIn(GoogleSignInAccount signInAccount) {
    // Build a drive client.
    mDriveClient = Drive.getDriveClient(getApplicationContext(), signInAccount);
    // Build a drive resource client.
    mDriveResourceClient = Drive.getDriveResourceClient(getApplicationContext(), signInAccount);

    // TODO:
}