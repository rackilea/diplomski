class LoginViewModel: ViewModel{

    LiveData<Result> login(String username, String password){

        LiveData<Result> resultLiveData = new MutableLiveData<Result>();

        // Let it be an async. call from Retrofit
        Repository.login(username, password, new Callback<Result>{
            void onResult(Result result){
                resultLiveData.value = result  // update the livedata.
            }
        }

        return resultLiveData;

    }

}