//starting facebook session
public void facebookstart() {
    // TODO Auto-generated method stub

    Session.openActiveSession(this, true, new Session.StatusCallback() {

        // callback when session changes state
        @SuppressWarnings("deprecation")
        @Override
        public void call(Session session, SessionState state,
                Exception exception) {
            if (session.isOpened()) {
                Log.e("",
                        "session details"
                                + session);
                acesstoken=session.getAccessToken();
                // make request to the /me API
                Request.executeMeRequestAsync(session,
                        new Request.GraphUserCallback() {

                            // callback after Graph API response with user
                            // object
                            @Override
                            public void onCompleted(GraphUser user,
                                    Response response) {
                                if (user != null) {
                                    pv = (ProfilePictureView) findViewById(R.id.profilePictureView1);
                                    pv.setProfileId(user.getId());
                                    welcome = (TextView) findViewById(R.id.name);
                                    welcome.setText("Hi  " + user.getName()+"\n"+""+user.getBirthday()
                                            + "!");
                                    logout.setText("log out");
                                    image();
                                }
                            }
                        });
            }
        }
    });
}