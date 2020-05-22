//Different activity to the above.
FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
if (user != null) {
    // Using getUid() which stays constant
    mUserId = user.getUid();
}