Task<GoogleSignInAccount> task = googleSignInClient.silentSignIn();
if (task.isSuccessful()) {
        GoogleSignInAccount signInAccount = task.getResult();
        Log.i(TAG, "immediate result available (silentSignIn)");
        updateViewWithGoogleSignIn(signInAccount);
    } else {
        // There's no immediate result ready, displays some progress indicator and waits for the
        // async callback.
        task.addOnCompleteListener(new OnCompleteListener<GoogleSignInAccount>() {
            @Override
            public void onComplete(@NonNull Task<GoogleSignInAccount> task) {
                try {
                    GoogleSignInAccount signInAccount = task.getResult(ApiException.class);
                    updateViewWithGoogleSignIn(signInAccount);
                } catch (ApiException apiException) {
                    // You can get from apiException.getStatusCode() the detailed error code
                    // e.g. GoogleSignInStatusCodes.SIGN_IN_REQUIRED means user needs to take
                    // explicit action to finish sign-in;
                    // Please refer to GoogleSignInStatusCodes Javadoc for details
                    updateButtonsAndStatusFromErrorCode(apiException.getStatusCode());
                }
            }
        });
    }