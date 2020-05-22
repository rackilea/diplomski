public static List<ParseObejct> getList() {
    ParseQuery<ParseObject> query = ParseQuery.getQuery(TABLE_NAME);
    query.whereEqualTo(KEY, VALUE);
    result = query.find();
}


 new AsyncTask<Void, Void, List<ParseObject>>() {

   @Override
   protected List<ParseObject> doInBackground(Void... params)
   {
       return ParseUtility.getList();
   }
 }.execute();