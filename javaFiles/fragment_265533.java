ParseQuery<ParseObject> query = ParseQuery.getQuery("_User");
    query.whereEqualTo("objectId","U8mCwTHOaC");
    query.findInBackground(new FindCallback<ParseObject>() {
        public void done(List<ParseObject> objects, ParseException e) {
            if (e == null) {
                // row of Object Id "U8mCwTHOaC"
            } else {
                // error
            }
        }
    });