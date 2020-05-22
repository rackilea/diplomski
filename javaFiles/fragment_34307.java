public void loadDateContent() {
    ApiMagazine apiMagazine = ApiMagazine.getInstance();
    ApiService apiService = apiMagazine.getApiService();
    compositeDisposable = new CompositeDisposable();
    Disposable disposable = apiService.getMagazines()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<Magazines>() {
                @Override
                public void accept(Magazines magazines) throws Exception {
                    //This will return Contents [1.*] of first Magazine [Акушерство и геникология]
                    List<Content> contents = magazines.getMagazines().get(0).getContent();
                    view.showDataContent(contents);
                }
            }, new Consumer<Throwable>() {
                @Override
                public void accept(Throwable throwable) throws Exception {
                    view.showError();
                }
            });
    compositeDisposable.add(disposable);
}