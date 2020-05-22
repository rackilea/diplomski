public class UserRepository extends AbstractRepository {

public static String TAG = "UserRepository";

ApiService mApiService;

SharedPreferences mPrefs;
Context mContext;

RemoteDataSource<User> mRemoteDataSource;

public UserRepository() {
    mApiService = new RetrofitClient().getApiService();
    mContext = App.getAppContext();
    mPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
    mRemoteDataSource = new RemoteDataSource<>();
}

protected Call<ApiResponse> performCall() {
    return mApiService.getUserInfo(mPrefs.getString(User.TOKEN_NAME, null));
}