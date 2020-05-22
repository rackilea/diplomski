public class MainViewModel extends ViewModel {

    ...

    private final MutableLiveData<Boolean> callFailure = new MutableLiveData<>();
    private final MutableLiveData<List<UserModel>> users = new MutableLiveData<>();

    public LiveData<Boolean> getCallFailure() {
        return callFailure;
    }

    public LiveData<Boolean> getUsers() {
        return users;
    }

    // THIS IS THE METHOD I'M CALLING FROM THE UI
    public void retryGetUsers() {
        callFailure.setValue(false);
        getUsers();
    }

    private void getUsers() {
        userRepo.getListUsers(new Callback<UserResponse>(){
            @Override
            public void onResponse(Call<UsersResponse> call, Response<UsersResponse> response) {
                users.setValue(response.body().getUserList());
            }

            @Override
            public void onFailure(Call<UsersResponse> call, Throwable t) {
                callFailure.setValue(true);
            }
        });
    }
}