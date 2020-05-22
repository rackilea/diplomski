try {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://cricapi.com/").
                    addConverterFactory(GsonConverterFactory.create())
            .build();

    APIService service = retrofit.create(APIService.class);

    Call<AllMatchItemObject> call = service.getAllMatch();



    call.enqueue(new Callback<AllMatchItemObject>() {

        @Override
        public void onResponse(Call<AllMatchItemObject> call, Response<AllMatchItemObject> response) {
            AllMatchItemObject allMatchItemObjectData = response.body();

            Log.d("onResponse", response.toString());
            hidepDialog();
        }

        @Override
        public void onFailure(Call<AllMatchItemObject> call, Throwable t) {
            Log.d("onFailure", t.toString());
            hidepDialog();
        }
    });
} catch (Exception e) {
    Log.d("onResponse", "There is an error");
    e.printStackTrace();
    hidepDialog();
}