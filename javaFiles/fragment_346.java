FirebaseUserMetadata metadata = auth.getCurrentUser().getMetadata();
if (metadata.getCreationTimestamp() == metadata.getLastSignInTimestamp()) {
    // The user is new, show them a fancy intro screen!
} else {
    // This is an existing user, show them a welcome back screen.
}