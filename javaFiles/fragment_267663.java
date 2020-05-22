/**
 * AsyncTask that uses the credentials from Google Sign In to access Youtube subscription API.
 */
private class GetSubscriptionTask extends AsyncTask<Account, Void, List<Subscription>> {

    @Override
    protected void onPreExecute() {
        showProgressDialog();
    }

    @Override
    protected List<Subscription> doInBackground(Account... params) {
        try {
            GoogleAccountCredential credential = GoogleAccountCredential.usingOAuth2(
                    RestApiActivity.this,
                    Collections.singleton(YOUTUBE_SCOPE));
            credential.setSelectedAccount(params[0]);

            YouTube youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                    .setApplicationName("Google Sign In Quickstart")
                    .build();

            SubscriptionListResponse connectionsResponse = youtube
                    .subscriptions()
                    .list("snippet")
                    .setChannelId("UCfyuWgCPu5WneQwuLBWd7Pg")
                    .execute();

            return connectionsResponse.getItems();
        } catch (UserRecoverableAuthIOException userRecoverableException) {
            Log.w(TAG, "getSubscription:recoverable exception", userRecoverableException);
            startActivityForResult(userRecoverableException.getIntent(), RC_RECOVERABLE);
        } catch (IOException e) {
            Log.w(TAG, "getSubscription:exception", e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(List<Subscription> subscriptions) {
        hideProgressDialog();

        if (subscriptions != null) {
            Log.d(TAG, "subscriptions : size=" + subscriptions.size());

            // Get names of all connections
            for (int i = 0; i < subscriptions.size(); i++) {
                Log.v(TAG, "subscription : " + subscriptions.get(i).getId());
            }
        } else {
            Log.d(TAG, "subscriptions: null");
            mDetailTextView.setText("None");
        }
    }
}