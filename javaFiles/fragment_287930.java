FacebookSdk.sdkInitialize(this);
    callbackManager =CallbackManager.Factory.create();

    // -----start putting in oncreate-----------------------

    LoginManager.getInstance().logInWithReadPermissions(UserActivity.this, Arrays.asList("public_profile", "user_friends","email"));

    facebookTime();

    //----onclicklisterner ---------------/

            callbackManager.onActivityResult(requestCode,resultCode,data);

    //---onactivityresult-------------/

    public void facebookTime() {
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        System.out.println("Success");
                        GraphRequest request = GraphRequest.newMeRequest(
                                loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                                    @Override
                                    public void onCompleted(JSONObject object, GraphResponse response) {
                                        //   Util.showCenteredToast(getActivity(), "object" + object);
                                        //     Util.showCenteredToast(getActivity(), "GraphResponse" + response);
                                        try {
                                            strEmail = object.getString("email");
                                            strUserName = object.getString("name");
                                            String id = object.getString("id");
                                            // write your code here
                                            //asyncTask.iSocialMediaResponse = LoginFragment.this;
                                            asyncTask.execute();


                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                        Bundle parameters = new Bundle();
                        parameters.putString("fields", "email,name");
                        //parameters.putString("fields", "user_friends");
                        request.setParameters(parameters);
                        //Log.e(" About to Graph Call", " ");
                        request.executeAsync();
                    }

                    @Override
                    public void onCancel() {
                        // App code
                        Util.showCenteredToast(UserActivity.this, "oncancel");
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                        Util.showCenteredToast(UserActivity.this, "exception" + exception);
                    }
                });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

    }