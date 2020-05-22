public class CustomCallback<T> implements Callback<T> {

    private String TAG = "CustomCallback";
    private ApiService mApiService = ConnectionsRequest.getApiService();
    private Config config = Config.getInstance();

    public CustomCallback(Call<T> call) {
        this.call = call;
    }

    @Override
    public void onResponse(Call<T> main_call, Response<T> response) {
        //Check if the token is still valid
        if (new Gson().toJson(response.body()).contains("needrefreshtoken")) {
            Log.i(TAG, "Generate new token");
            main_call.cancel();
            RetrofitCallback.enqueue(mApiService.getToken(config.refreshtoken()), new Callback<TokenModel>() {
                @Override
                public void onResponse(@NonNull Call<TokenModel> call, @NonNull Response<TokenModel> response) {
                    config.token = response.body().getToken();
                    Log.i(TAG, "New token generated and saved");
                    retryMainRequest();
                }

                @Override
                public void onFailure( @NonNull Call<TokenModel> call, @NonNull Throwable t) {

                }
            });

        }

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Log.e(TAG, t.toString());
    }

    private void retryMainRequest() {
        Log.i(TAG, "Retry request");
        call.clone().enqueue(this);
    }
}