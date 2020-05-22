public LiveData<State> isVerifiedUser(int userId){

    MutableLiveData<State> isVerified = new MutableLiveData();

    executor.execute(() -> {           
        Response<User> response = webservice.getVerifyUser(userId).execute();
        // Update state here.
        isVerified.postValue(valueHere)
    });

    return isVerified;
}