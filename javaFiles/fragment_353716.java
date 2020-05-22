RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint(API_URL) 
            .setConverter(new StringConverter())
            .build();

YourAPI api = restAdapter.create(YourAPI.class);
api.yourService(parameter,new RestCallback<String>() { 

    @Override
    public void success(String response, Response retrofitResponse) {
        super.success(response, retrofitResponse);
        //process your response here
        //convert it from string to your POJO, JSON Object, or JSONArray manually

    }

    @Override
    public void failure(RetrofitError error) { 
       super.failure(error);
    }

});