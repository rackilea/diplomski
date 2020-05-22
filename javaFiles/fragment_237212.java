@OnClick(R.id.button)
@Optional
void onClickButton()
{
        JsonObject params = new JsonObject();
        params.addProperty("key", "value");

        Call < MyModel > call = myApiService.postCustomRequest(params);
        RetrofitCallback.enqueue(call, new Callback < MyModel >() {
            @Override
            public void onResponse(@NonNull Call<NewIncidentData> call, @NonNull Response<NewIncidentData> response) {
                //Do you stuff here, no need to add custom request code
            }

            @Override
            public void onFailure(@NonNull Call<NewIncidentData> call, @NonNull Throwable t) {
                  //Same here
            }
        });

}