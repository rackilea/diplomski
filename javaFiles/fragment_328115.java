@Override
    public void userLogin(String device_id, String device_type, String username, String password) {
        getCompositeDisposable().add(loginActivtiyInteractor.userLogin(device_id, device_type, username, password)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(loginResponse -> {
                    if (loginResponse != null) {
                        if (loginResponse.getCode() == 1) {
                            getMvpView().hideLoading();
                            getMvpView().updateView(loginResponse);
                        } else {
                            getMvpView().hideLoading();
                            getMvpView().onError(loginResponse.getMsg());
                        }
                    }
                }, throwable -> {
                    throwable.printStackTrace();
                    getMvpView().onError(throwable.getLocalizedMessage());
                    getMvpView().hideLoading();
                }));
    }