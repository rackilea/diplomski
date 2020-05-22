new TwitAsyncTask(this, tweetListener).execute();

 private OnTweetsLoadedListener tweetListener = new OnTweetsLoadedListener {
     @Override
     public void onTweetsLoaded(List<String> tweets) {
             arrayAdapter =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tweets);
             listview.setAdapter(arrayAdapter);      
     }
 }     

private static class TwitAsyncTask extends AsyncTask<Void, Void, List<String>>{    

    private final Context context;
    private final OnTweetsLoadedListener listener;
    private ProgressDialog progressDialo;

    public interface OnTweetsLoadedListener() {
         void onTweetsLoaded(List<String> tweets);
    }

    public TwitAsyncTask(Context context, OnTweetsLoadedListener listener) {
        this.context = context;
        this.listener = listener;
    } 

    @Override
    protected void onPreExecute() {
         super.onPreExecute();
         progressDialo = ProgressDialog.show(context, "", "En cours...");
    }

    @Override
    protected Void doInBackground(Void... params) {
         List<String> tweets = new ArrayList<String>();
        try {
            Query query = new Query();
            query.setQuery("%23morocco");
            QueryResult result = twitter.search(query);
            for (twitter4j.Status status : result.getTweets()) {
                 String stat = "@" + status.getUser().getScreenName() + ":" + status.getText() +":"+status.getGeoLocation() +":"+status.getCreatedAt();
                 tweets.add(stat);
                  Log.i("TAG"," tweeeeeeet"+stat);
            }
        } catch (TwitterException e) {
            Log.e("TAG", "ASyncFail", e);
        }
        Log.i("TAG","done");
        return tweets;
    }

    @Override
    protected void onPostExecute(List<String> tweets) {
        super.onPostExecute(result);
        progressDialo.dismiss();
        if(listener != null) {
             listener.onTweetsLoaded(tweets);
        }
    }