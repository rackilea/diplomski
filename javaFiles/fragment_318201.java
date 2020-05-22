public AndroidPlatform(Activity context){
        this.context = context;
        callbackManager = CallbackManager.Factory.create();
    }

    @Override
    public void fbLogin() {

        String a[] = new String[]{"user_friends"};
        LoginManager.getInstance().logInWithReadPermissions(context, Arrays.asList(a)); //Log in to FB
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                System.out.println("Success");
                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(
                                    JSONObject object,
                                    GraphResponse response) {
                                // Application code
                                Log.v("LoginActivity", response.toString());
                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender, birthday");
                request.setParameters(parameters);
                request.executeAsync();
            }

            @Override
            public void onCancel() {
                System.out.println("Cancel");
            }

            @Override
            public void onError(FacebookException e) {
                System.out.println("Error");
            }
        });

    }

    public CallbackManager getCM(){
        return callbackManager;
    }