if(!task.isSuccessful()) {
    try {
        throw task.getException();
    } catch(FirebaseAuthWeakPasswordException e) {
        mTxtPassword.setError(getString(R.string.error_weak_password));
        mTxtPassword.requestFocus();
    } catch(FirebaseAuthInvalidCredentialsException e) {
        mTxtEmail.setError(getString(R.string.error_invalid_email));
        mTxtEmail.requestFocus();
    } catch(FirebaseAuthUserCollisionException e) {
        mTxtEmail.setError(getString(R.string.error_user_exists));
        mTxtEmail.requestFocus();
    } catch(Exception e) {
        Log.e(TAG, e.getMessage());
    }
}