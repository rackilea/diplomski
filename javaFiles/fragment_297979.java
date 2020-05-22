public class UserRepository {    
    private ApiService apiService;
    private static UserRepository userRepository;

    private UserRepository() {
        apiService = RestClient.getClient().create(ApiService.class);
    }

    public synchronized static UserRepository getInstance() {
        if (userRepository == null) userRepository = new UserRepository();
        return userRepository;
    }

    // Your example code
    public LiveData<User> fetchUser() {
        // Your problem lies here. Every time you fetch user data, you create a new LiveData.
        // Instead, fetch user should update the data on a pre-existing LiveData.
        final MutableLiveData<User> data = new MutableLiveData<>();
        Call<User> call = apiService.getUser();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                if (response.body() != null) {
                    data.postValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                data.postValue(null);
                t.printStackTrace();
            }
        });
        return data;
    }

    // My alterations below:
    private MutableLiveData<User> userLiveData = new MutableLiveData<>();

    public LiveData<User> getUser() {
        return userLiveData;
    }

    public LiveData<User> fetchUser2() {
        Call<User> call = apiService.getUser();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                if (response.body() != null) {
                    userLiveData.postValue(response.body());
                }
                // TODO: Consider a fallback response to the LiveData here, in the case that bad data is returned. Perhaps null?
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                userLiveData.postValue(null);
                t.printStackTrace();
            }
        });
        return userLiveData;
    }
}