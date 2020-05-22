private void handleResponseLeft(List<MainCategoryData> storeCoupons) {
    List<MainCategoryData> list = new ArrayList<>(storeCoupons);
    RepoAdapter adapter = new RepoAdapter(list);
    recyclerView.setAdapter(adapter);
}

private void handleResponseRight(List<MainCategoryData> storeCoupons) {
    List<MainCategoryData> list2 = new ArrayList<>(storeCoupons);
    RepoAdapter adapter2 = new RepoAdapter(list2);
    recyclerView2.setAdapter(adapter2);
}

ApiServiceMain s = retrofit.create(ApiServiceMain.class);

s.maincategorya()
 .subscribeOn(Schedulers.io())
 .observeOn(AndroidSchedulers.mainThread())
 .subscribe(this::handleResponseLeft, this::handleError);

s.maincategoryap()
 .subscribeOn(Schedulers.io())
 .observeOn(AndroidSchedulers.mainThread())
 .subscribe(this::handleResponseRight, this::handleError);