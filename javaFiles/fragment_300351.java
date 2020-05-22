private void runQuery() {
    ParseQuery<ParseObject> query = ParseQuery.getQuery("Hospitales");
    query.whereEqualTo("Codigo", id);
    query.getFirstInBackground(new GetCallback<ParseObject>() {
        public void done(ParseObject object, ParseException e) {
            if (object == null) {
                Log.d("score", "The getFirst request failed.");
                // You don't have a good value to use, so figure
                // out a way to handle that scenario
            } else {
                Log.d("id", "Retrieved the object.");
                String status = object.getString("Hospital");
                m2Status = object.getString("Hospital");
                System.out.println("Hospital: " + status);
                System.out.println(status + m2Status);
                // You have a good value to use, so
                // now you can actually use it
                afterQueryProcessing();
            }
        }
    });
}
private void afterQueryProcessing() {
    // You can access m2Status here reliably,
    // assuming you only call this method
    // as shown above, but you should still
    // use defensive programming
    if (m2Status != null) {
        // Now you know you have a value to use...
    }
}