public void GetCaregiver() {
    OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(new HeaderInterceptor()).build();

    Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(zorggemakURL)
            .callFactory(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    RESTInterface service = retrofit.create(RESTInterface.class);

    Call<List<Caregiver>> call = service.getCaregivers();

    call.enqueue(new Callback<List<Caregiver>>() {
        @Override
        public void onResponse(Call<List<Caregiver>> call, retrofit2.Response<List<Caregiver>> response) {
           List<Caregiver> caregivers = response.body();
            String test = "";
        }

        @Override
        public void onFailure(Call<List<Caregiver>> call, Throwable t) {
            Log.d("Response", t.toString());
        }
    });
}