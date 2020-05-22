public class RetrofitCallback {
    public static <T> void enqueue(Call<T> call, final Callback<T> callback) {
        Log.i(TAG, "HTTP Request : " + call.request().url());
        call.enqueue(new CustomCallback<T>(call) {
            @Override
            public void onResponse(Call<T> call,  Response<T> response) {
                super.onResponse(call, response);
                if(call.isCanceled())
                    return;
                callback.onResponse(call, response);
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                super.onFailure(call, t);
                callback.onFailure(call, t);
            }
        });
    }
}