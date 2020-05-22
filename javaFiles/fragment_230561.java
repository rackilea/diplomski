@Override
        public void onSuccess(final LoginResult loginResult) {
            GraphRequest request = GraphRequest.newMeRequest(
                    loginResult.getAccessToken(),
                    new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(
                                JSONObject object,
                                GraphResponse response) {

                            try {
                                if (object != null) {
                                    String name  = object.getString("first_name") + " "+object.getString("last_name");
                                   }
                            } catch (JSONException e) {

                            }
                        }
                    });
            Bundle parameters = new Bundle();
            parameters.putString("fields", "id,name,email, first_name, last_name, gender");
            request.setParameters(parameters);
            request.executeAsync();
        }