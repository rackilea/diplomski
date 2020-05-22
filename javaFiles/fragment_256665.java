MyService service = restAdapter.create(MyService.class);

service.points(path, new Callback<YourClassType>)() {
    @Override
    public void success(YourClassType foo, Response response)
    {
        // success
    }

    @Override
    public void failure(RetrofitError error) {
        // something went wrong
    }
});