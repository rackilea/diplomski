public class MyRestClientClass{
    //class context
    MyService mService;

    //helper method for service instantiation. call this method once
    void initializeRestClient()
    {
        RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint(API_URL)
            .build();
        mService = restAdapter.create(MyService.class);
    }

    //your service request method
    void updateMap()
    {
        mService.points(....)
    }
}