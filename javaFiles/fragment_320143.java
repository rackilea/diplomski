loginButton.setCallback(new Callback<TwitterSession>() {
  @Override
  public void success(Result<TwitterSession> result) {

    TwitterApiClient twitterApiClient = TwitterCore.getInstance().getApiClient();
    AccountService service = twitterApiClient.getAccountService();

    service.verifyCredentials(false, false, false).enqueue(new Callback<User>() {
      @Override
      public void success(Result<User> result) {

          // I converted the user object into json for readability purposes
          User user = result.data;
          Gson gson = new Gson();
          String jsonData = gson.toJson(user);
          Log.i("Json> User  ", jsonData + "");
      }

      @Override
      public void failure(TwitterException exception) {
      }
    });
  }

  @Override
  public void failure(TwitterException exception) {
    // Do something on failure
  }
});