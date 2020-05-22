class TimeSettingViewModel(val context: Application, val retrofit: Retrofit) : AndroidViewModel(context) {

    private val compositeDisposable = CompositeDisposable()
    val accessTokenLiveData: MutableLiveData<AccessToken> = MutableLiveData()

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    fun getAccessToken(){
        retrofit.getAccessToken("some","thing","here")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    accessTokenLiveData.value = it
                },{
                    it.printStackTrace()
                })

    }


}