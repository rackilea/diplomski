loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
    @Override
    public void onSuccess(LoginResult loginResult) {

        final ProgressDialog pd = new ProgressDialog(Login.this);
        pd.setMessage("Please Wait..");
        String accessToken = loginResult.getAccessToken().getToken();
        Log.i("accessToken", accessToken);

        GraphRequest request = GraphRequest.newMeRequest(
                loginResult.getAccessToken(),
            new GraphRequest.GraphJSONObjectCallback() {
                @Override
                public void onCompleted(JSONObject object,
                                        GraphResponse response) {
                    Log.i("LoginActivity",
                        response.toString());
                    try {
                        id = object.getString("id");
                        try {
                            URL profile_pic = new URL(
                                                    "https://graph.facebook.com/" + id + "/picture?type=large");
                            user_image = profile_pic.toString();
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }

                        name = object.getString("name");
                        email = object.getString("email");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });
        Bundle parameters = new Bundle();
        parameters.putString("fields",
                "id,name,email,gender, birthday");
        request.setParameters(parameters);
        request.executeAsync();
        pd.show();
    }

    @Override
    public void onCancel() {
        // App code
    }

    @Override
    public void onError(FacebookException exception) {
        Toast.makeText(getBaseContext(),exception.toString(),Toast.LENGTH_LONG).show();
    }
});