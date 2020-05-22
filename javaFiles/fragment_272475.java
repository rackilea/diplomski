ParseQuery<ParseObject> query = ParseQuery.getQuery("Code_Description");
query.findInBackground(new FindCallback<ParseObject>() {
    public void done(List<ParseObject> markers, ParseException e) {
        if (e == null) {
            // update your list here somehow
            // listAdapter.clear();
            // listAdapter.addAll(markers);

        } else {
            Log.e("Error",e.getMessage());
        }
    }
});