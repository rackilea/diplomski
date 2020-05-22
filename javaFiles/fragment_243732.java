public void getCoast(String origin,
                     String destination,
                     String weight,
                     String courier) {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(ApiUrl.URL_ROOT_HTTPS)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    ApiService service = retrofit.create(ApiService.class);
    Call<ItemCost> call = service.getCost(
            "c5333cdcc37b3511c909088d99587fd8",
            origin,
            destination,
            weight,
            courier
    );


    call.enqueue(new Callback<ItemCost>() {
        @Override
        public void onResponse(Call<ItemCost> call, Response<ItemCost> response) {

            Log.v("wow", "json : " + new Gson().toJson(response));
            progressDialog.dismiss();

            if (response.isSuccessful()) {

                int statusCode = response.body().getRajaongkir().getStatus().getCode();

                if (statusCode == 200) {
                    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View alertLayout = inflater.inflate(R.layout.custom_results, null);
                    alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("Result Cost");
                    alert.setMessage("this result your search");
                    alert.setView(alertLayout);
                    alert.setCancelable(true);

                    ad = alert.show();


                    String originCity = response.body().getRajaongkir().getOriginDetails().getCityName();
                    String originPostalCode = response.body().getRajaongkir().getOriginDetails().getPostalCode();
                    String destinationCity = response.body().getRajaongkir().getDestinationDetails().getCityName();
                    String destinationPostalCode = response.body().getRajaongkir().getDestinationDetails().getPostalCode();

                    //results
                    List<com.bagicode.cekongkir.model.cost.Result> ListResults = response.body().getRajaongkir().getResults();

                    //costs
                    List<com.bagicode.cekongkir.model.cost.Cost> ListCosts = response.body().getRajaongkir().getResults().get(0).getCosts();

                   //cost
                   List<com.bagicode.cekongkir.model.cost.Cost_> ListCost = response.body().getRajaongkir().getResults().get(0).getCosts().get(0).getCost();



                    mListView = (ListView) alertLayout.findViewById(R.id.listItem);
                    adapter_results = new ResultsAdapter(MainActivity.this, originCity, originPostalCode, destinationCity, destinationPostalCode, ListResults, ListCosts, ListCost);


                    mListView.setAdapter(adapter_results);
                    mListView.setClickable(true);

                    adapter_results.notifyDataSetChanged();



                } else {

                    String message = response.body().getRajaongkir().getStatus().getDescription();
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }

            } else {
                String error = "Error Retrive Data from Server !!!";
                Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onFailure(Call<ItemCost> call, Throwable t) {

            progressDialog.dismiss();
            Toast.makeText(MainActivity.this, "Message : Error " + t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    });

}