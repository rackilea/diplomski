Request.executeMeRequestAsync(Session.getActiveSession(), new Request.GraphUserCallback() {

                @Override
                public void onCompleted(GraphUser user, Response response) {
                    FacebookRequestError error = response.getError();
                    GraphObject graphObject = response.getGraphObject();
                    if(graphObject != null) {
                        if(error == null) {
                            Preferences.saveUserInfo(user.getId(), FetchGroups.this);
                            Preferences.saveUserName(user.getName(), FetchGroups.this);
                             userid = user.getId();
                        }
                    }
                }
            });