public LiveData<User> fetchUser() {
    Call<User> call = apiService.getUser();
    call.enqueue(new Callback<User>() {
        @Override
        public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
            if (response.body() != null) user.postValue(response.body());
        }

        @Override
        public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
            user.postValue(null);
            t.printStackTrace();
        }
    });

    return user;
 }