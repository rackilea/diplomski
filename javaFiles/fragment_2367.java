public class AsyncTaskParseJson extends AsyncTask<String, Void, List<String>> {    


private see_schedule_activity activity;
//... the rest

public AsyncTaskParseJson(see_schedule_activity activity) {
    this.activity = activity;
}

@Override
protected List<String> doInBackground(String... arg0) {
    // create scheduleList 
    return scheduleList;
}

@Override
protected void onPostExecute(List<String> results) {
    activity.update(results);
}
//...