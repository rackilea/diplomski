PhotoUser pUser;
ParseQuery<Photo> UserQuery = ParseQuery.getQuery(Photo.class);
    UserQuery.whereEqualTo("objectId", PhotoID);
    UserQuery.getFirstInBackground(new GetCallback<Photo>() {
        @Override
        public void done(Photo pPhoto, ParseException error) {
            pUser = pPhoto.getUser();
        }
    });