protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    forecastList = new ArrayList<>();
    parentView = findViewById(R.id.parentLayout);


    LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

    myList = (RecyclerView) findViewById(R.id.listView);
    myList.setLayoutManager(layoutManager);

    ApiService apiService = RetrofitClient.getApiService();

    Call<ForecastList> call = apiService.getMyJSON();

    call.enqueue(new Callback<ForecastList>() {
        @Override
        public void onResponse(Call<ForecastList> call, Response<ForecastList> response) {
            if (response.isSuccessful()) {
                forecastList = response.body().getForecasts();

                adapter = new MyForecastAdapter(MainActivity.this, forecastList);
                myList.setAdapter(adapter);
            } else {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onFailure(Call<ForecastList> call, Throwable t) {

        }
    });
}