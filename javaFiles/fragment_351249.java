try {
        FirebaseToken decodedToken = Tasks.await(
                FirebaseAuth.getInstance().verifyIdToken(firebaseAuthToken));
} catch (ExecutionException | InterruptedException e) {
        log.error("Error: {}", e.getLocalizedMessage());
}