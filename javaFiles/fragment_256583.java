public void checkNetworkAvailable() {

    ReactiveNetwork
            .observeInternetConnectivity()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<Boolean>() {
                @Override
                public void onSubscribe(final Disposable d) {
                    // this will be invoked before operation is started
                }

                @Override
                public void onNext(final Boolean isConnectedToInternet) {
                    // do your action, when you're connected to the internet
                    changeOnlineStatus(isConnectedToInternet ? ConnectionQuality.EXCELLENT : ConnectionQuality.POOR);

                }

                @Override
                public void onError(final Throwable e) {
                    // handle an error here <-----------------
                    Snackbar.make(getView(), "Network timeout!", Snackbar.LENGTH_LONG).show();
                }

                @Override
                public void onComplete() {
                    // this will be invoked when operation is completed
                }

            });
}