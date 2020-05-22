void performEmailVerification() {
    if (firebaseAuth.getCurrentUser().isEmailVerified()) {
        // Everything is OK, perform your task
        checkSomethingOnFirestore();
        return;
    }

    //User not verified, but you still get a database reference and try to get the email.
    final DocumentReference documentReference = ... //Error produced