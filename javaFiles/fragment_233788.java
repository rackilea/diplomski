public interface MyObjectView {
    void resultSuccess(int status);
}


MyObjectView myView

Public MyPresenterConstructor(MyObjectView myView){
    this.myView = myView;
}


@Override
    public void updateProfile() {
        Disposable d = updateInfoInteractor
                .build(new ProfileUpdateInfoInteractor.Param(view.getPhone(), view.getLocation(), view.getDescription()))
                .observeOn(schedulers.main())
                .subscribeWith(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        Timber.d("Profile edited");

                        // Show alert dialog here!
            myView.resultSuccess(200)   // Okee

                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.d("Error at edit profile");
                    }
                });
    }