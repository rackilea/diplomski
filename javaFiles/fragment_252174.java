private void handleSignInResult(@NonNull Task<GoogleSignInAccount> completedTask) {
    try {
        account = completedTask.getResult(ApiException.class);
        if(isSignedIn()) {
            Toasty.success(this, "Success!", Toast.LENGTH_SHORT, true).show();
            startActivity(new Intent(MainActivity.this, Home.class));
        }
    } catch (ApiException e) {
        if(e.getCause() != null) {
            Toast.makeText(this, "Failed to login because: " + e.getCause(), Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Failed to login because: No account Selected!", Toast.LENGTH_LONG).show();
        }
    }
}`