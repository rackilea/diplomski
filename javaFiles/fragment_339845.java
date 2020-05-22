@Override
public void initialize() {
    if (!isViewAttached()) {
        throw new ViewNotAttachedException();
    }
    disposable = listUseCase.execute(null)
            .subscribeOn(schedulerProvider.io()) // Move subscribe on here
            .observeOn(schedulerProvider.main()) // Change threads here
            .doOnSubscribe(new Consumer<Disposable>() {
                @Override
                public void accept(@NonNull Disposable disposable) throws Exception {
                    getView().showLoading(true); // This should be on the main thread also
                }
            })
            .doFinally(new Action() {
                @Override
                public void run() throws Exception {
                    getView().showLoading(false);
                }
            })
            .subscribe(
                    new Consumer<List<AccountEntity>>() {
                        @Override
                        public void accept(@NonNull List<AccountEntity> accountEntities) throws Exception {
                            getView().setAccounts(accountEntities);
                        }
                    },
                    new Consumer<Throwable>() {
                        @Override
                        public void accept(@NonNull Throwable throwable) throws Exception {
                            if (isViewAttached()) {
                                getView().showError(throwable.getMessage());
                            }
                        }
                    }
            );
}

@Override
public void dispose() {
    if (disposable != null) {
        disposable.dispose();
    }
}