public class AbstractRepository {

protected abstract Call<ApiResponse> performCall();

public RemoteDataSource getRemoteDataSource() {
    mRemoteDataSource.setIsLoading();
    Call<ApiResponse> userCall = performCall();
    userCall.enqueue(new Callback<ApiResponse>() {
        @Override
        public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
            mRemoteDataSource.setIsLoaded();
            mRemoteDataSource.setData(response.body().getUser());
            mRemoteDataSource.setStatus(response.body().getStatus());
            mRemoteDataSource.setMessage(response.body().getMessage());
        }

        @Override
        public void onFailure(Call<ApiResponse> call, Throwable t) {
            Log.e(TAG, t.getMessage());
            mRemoteDataSource.setFailed(t.getMessage());
        }
    });

return mRemoteDataSource;
}

}