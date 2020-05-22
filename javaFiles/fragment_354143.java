public class LoginAsyncTaskLoader extends HttpAsyncTaskLoader {
    private LoginResponse mLoginResponse;
    public LoginAsyncTaskLoader(Context context, ApiClient client, ApiRequest request) {
        super(context, client, request);
    }

    @Override
    public LoginResponse loadInBackground() {
        ApiResponse apiResponse = executeRequest(mRequest);
        mLoginResponse = new LoginResponse(apiResponse.getResources(), apiResponse.response, apiResponse.responseJson, apiResponse.getError());
        return mLoginResponse;
    }

    @Override
    public ApiResponse getResponse() {
        return mLoginResponse;
    }
}