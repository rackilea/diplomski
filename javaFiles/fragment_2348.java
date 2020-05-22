private interface Callback {
void done(boolean result);
}

private class RefreshAccessTokenAsyncTask extends AsyncTask<String, Void, Boolean> {

private Callback cb;

private RefreshAccessTokenAsyncTask(Callback callback)
    cb = callback;
}

@Override
protected Boolean doInBackground(String... params) {
    String refreshToken = params[0];
    try {

        // Get a new access token using the refresh token
        // in the background ...
        AccessTicket accessTicket = refreshAccessTicket(refreshToken);

        // ... and save the updated information to the shared
        // preferences
        saveAccessTicket(accessTicket);
        return true;
    } catch (Exception ex) {

        // If the call for a new access token fails for any reason,
        // return FALSE.  We'll force the user to log in again to
        // get a completely new access ticket.
        return false;
    }
}

@Override
protected void onPostExecute(Boolean isLoggedIn) {
    super.onPostExecute(isLoggedIn);
    Log.d(TAG, "RefreshAccessTokenAsyncTask.onPostExecute() : " +
            "Returning isLoggedIn value of " + isLoggedIn);
    cb.done(isLoggedIn);
}