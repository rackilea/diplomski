public class NewsController {
    private RestAdapter restAdapter;
    static final String API_URL = "[Enter your API base url here]";
    public void getNews(){
        OkHttpClient mOkHttpClient = new OkHttpClient();
        mOkHttpClient.setConnectTimeout(15000,TimeUnit.MILLISECONDS);
        mOkHttpClient.setReadTimeout(15000,TimeUnit.MILLISECONDS);
        restAdapter = new RestAdapter.Builder().setEndpoint(API_URL).setClient(new OkClient(mOkHttpClient)).setLogLevel(RestAdapter.LogLevel.FULL) .build();
        GetNewsService service = restAdapter.create(GetNewsService.class);

        Callback<List<RootObject> cb = new Callback<List<RootObject>>() {
          @Override 
          public void success(List<RootObject> rootObjectList, Response response) { 
             //whatever you want to do with the fetched news items
          } 

          @Override 
          public void failure(RetrofitError error) { 
            //whatever you want to do with the error
          } 
        };
        service.GetNewsItems(cb);    
    }
}