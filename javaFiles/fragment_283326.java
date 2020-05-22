public class RetrofitCallback<S> implements Callback<S> {
private static final String TAG = RetrofitCallback.class.getSimpleName();


@Override
public void success(S s, Response response) {

}

@Override
public void failure(RetrofitError error) {
    Log.e(TAG, "Failed to make http request for: " + error.getUrl());
    Response errorResponse = error.getResponse();
    if (errorResponse != null) {
        Log.e(TAG, errorResponse.getReason());
        if (errorResponse.getStatus() == 500) {
            Log.e(TAG, "Handle Server Errors Here");
        }
    }
}
}