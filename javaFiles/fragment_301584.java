public class FetchParseQueryTask extends AsyncTask<PagingOptions, Void, List<ParseObject>> {

  private OnTaskCompleted mTaskCompleted;

  public FetchParseQueryTask(OnTaskCompleted activityContext){
    mTaskCompleted = activityContext;
  }

  @Override
  protected List<ParseObject> doInBackground(PagingOptions... params) {
    PagingOptions pagingOptions = params[0];
    ParseQuery<ParseObject> query = ParseQuery.getQuery("TABLE_NAME");

    query.setLimit(pagingOptions.getLimit());
    query.setSkip(pagingOptions.getPage() * pagingOptions.getLimit());

    try {
        return query.find();
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return null;
  }

  protected void onPostExecute(List<ParseObject> result) {
    super.onPostExecute(result);

    if (mTaskCompleted != null) {
        mTaskCompleted.onTaskCompleted(result);
    }
  }
}