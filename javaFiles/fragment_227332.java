public class EndpointsTask extends AsyncTask<Context, Integer, User> {

   protected User doInBackground(Context... contexts) {

        Userendpoint.Builder endpointBuilder = new Userendpoint.Builder(
            AndroidHttp.newCompatibleTransport(),
            new JacksonFactory(),
            new HttpRequestInitializer() {
                public void initialize(HttpRequest httpRequest) { }
            });
        Userendpoint endpoint = CloudEndpointUtils.updateBuilder(
            endpointBuilder).build();

        User user = null;
        try {
            user = endpoint.getUser("username").execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
  }

  protected void onPostExecute(User user) {
        //update your UI here
        usernameTextView.setText(user.getUsername());
        locationTextView.setText(user.getLocation());
        ageTextView.setText(Integer.toString(user.getAge()));
        occupationTextView.setText(user.getOccupation());
        weightTextView.setText(Integer.toString(user.getWeight()));
        genderTextView.setText(user.getGender());
  }

}