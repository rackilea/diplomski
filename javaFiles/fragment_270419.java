public void getProfileInformation() {
mAsyncRunner.request("me", new RequestListener() {
    @Override
    public void onComplete(String response, Object state) {
        Log.d("Profile", response);
        String json = response;
        try {
            JSONObject profile = new JSONObject(json);
            // getting name of the user
            String name = profile.getString("name");
            // getting email of the user
            String email = profile.getString("email");
            //getting user birthday
            String birth_day=profile.getString("birthday");

            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "Name: " + name + "\nEmail: " + email, Toast.LENGTH_LONG).show();
                }

            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onIOException(IOException e, Object state) {
    }

    @Override
    public void onFileNotFoundException(FileNotFoundException e,
            Object state) {
    }

    @Override
    public void onMalformedURLException(MalformedURLException e,
            Object state) {
    }

    @Override
    public void onFacebookError(FacebookError e, Object state) {
    }
});