interface Callback<T> {

    void success(T result);
    void failure(Exception error);
}

void getUserTastes(Callback<ArrayList<String>> callback){

// Note the special way to get a query for the user table
ParseQuery<ParseUser> query = ParseUser.getQuery();
query.selectKeys(Arrays.asList("tastes"));
// TODO: Specify the object id

query.getInBackground(test, new GetCallback<ParseUser>() {
    public void done(ParseUser object, ParseException e) {

            if (e == null) {

                ArrayList<String> userTastesGot = (ArrayList<String>) object.get("tastes");

                Log.d("User", "Retrieved " + userTastesGot);

                callback.success(userTastesGot);

            } else {
                callback.failure(e);
            }
        }

});

}