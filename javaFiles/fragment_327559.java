// set permission list
          authButton.setReadPermissions(Arrays.asList("basic_info","email"));
          // session state call back event
          authButton.setSessionStatusCallback(new Session.StatusCallback() {

           @SuppressWarnings("deprecation")
        @Override
           public void call(Session session, SessionState state, Exception exception) {

            if (session.isOpened()) {
                      Log.i(TAG,"Access Token"+ session.getAccessToken());
                      Request.executeMeRequestAsync(session,
                              new Request.GraphUserCallback() {
                                  @Override
                                  public void onCompleted(GraphUser user,Response response) {
                                      if (user != null) { 
                                       Log.i(TAG,"User ID "+ user.getId());
                                       Log.i(TAG,"Email "+ user.asMap().get("email"));
                                       Log.i(TAG,"Name "+ user.asMap().get("name"));
                                       uName = user.asMap().get("name").toString();
                                       savePreferences();
                                       restorePreferences();

                                                                                      }
                                  }
                              });
                  }

           }
          });