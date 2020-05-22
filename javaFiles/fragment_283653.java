public class Util {
    public interface Callback {
        void onResponse(UserInfo info);
    }
    private UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void login(final String email, final String password, final Callback callback) {
        Call<UserInfo> loginCall = apiInterface.login(email, password);
        loginCall.enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                userInfo = response.body();
                callback.onResponse(userInfo);
                Log.d("user", userInfo.toString());
        }

        @Override
        public void onFailure(Call<UserInfo> call, Throwable t) {
        }
    });
}