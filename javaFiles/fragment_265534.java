ParseQuery<ParseObject> query = ParseQuery.getQuery("_User");
    query.whereEqualTo("objectId",ParseUser.getCurrentUser().getObjectId());
    query.findInBackground(new FindCallback<ParseObject>() {
        public void done(List<ParseObject> objects, ParseException e) {
            if (e == null) {
                // row of Object Id "Current USer"
            } else {
                // error
            }
        }
    });