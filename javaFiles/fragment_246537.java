RestAdapter restAdapter = new RestAdapter.Builder()
            .setServer("baseURL")     
            .build();
ClientInterface service = restAdapter.create(ClientInterface.class);

Callback callback = new Callback() {
    @Override
    public void success(Object o, Response response) {

    }

    @Override
    public void failure(RetrofitError retrofitError) {

    }
};
service.listUsers(666, callback);