public void patchUsersExceptCurrentUser(String name,ParseListener listener) {
        ParseQuery<ParseUser> query = ParseUser.getQuery();
        query.whereNotEqualTo("username", name);
        query.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> objects, ParseException e) {
                if (e == null) {
                    listener.onSucess(objects);
                }
                else{
                    listener.onError(e);
                }
            }
        });
    }

    public interface ParseListener{
        void onSucess(List<Object>objects);
        void onError(ParseException e);
    }