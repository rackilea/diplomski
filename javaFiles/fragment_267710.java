FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
if (user != null) {
// Name, email address, and profile photo Url
String name = user.getDisplayName();
String email = user.getEmail();
Uri photoUrl = user.getPhotoUrl();

// Check if user's email is verified
boolean emailVerified = user.isEmailVerified();

// The user's ID, unique to the Firebase project. Do NOT use this value to
// authenticate with your backend server, if you have one. Use
// FirebaseUser.getIdToken() instead.
String uid = user.getUid();
}