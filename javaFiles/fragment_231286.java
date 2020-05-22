public void retrofitView() {
    ProgressBar progressBar;
    progressBar = findViewById(R.id.ProgressBar_MainActivity);
    DoubleBounce doubleBounce = new DoubleBounce();
    progressBar.setIndeterminateDrawable(doubleBounce);
    progressBar.setVisibility(View.VISIBLE);
    Call<List<Restaurants>> call = RetrofitClient.apiService.getRestaurants();
    call.enqueue(new Callback<List<Restaurants>>() {
        @Override
        public void onResponse(Call<List<Restaurants>> call, Response<List<Restaurants>> response) {
            progressBar.setVisibility(View.GONE); //This will make your progress bar visibility off after data load successfully
            restaurantRecyclerInit(response.body());
        }

        @Override
        public void onFailure(Call<List<Restaurants>> call, Throwable t) {
            progressBar.setVisibility(View.GONE); // Same here also
            Toast.makeText(MainActivity.this, "ddd", Toast.LENGTH_SHORT).show();
        }
    });
}