ApiObject service = ServiceGenerator.createService(ApiObject.class);
        Observable<List<ManagerDTO>> observManagers = service.getManagers();
        observManagers
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<ManagerDTO>>() {
                    @Override
                    public void onCompleted() {
                        //do nothing
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("OnError", e.getMessage());
                        Toast.makeText(context, R.string.toast_connection_false, Toast.LENGTH_SHORT).show();
                        initRecyclerView(Cache.getManagers());
                        managersSwipe.setRefreshing(false);
                    }

                    @Override
                    public void onNext(List<ManagerDTO> managers) {
                        Log.e("OnNext", "Connect is OK");
                        sortManagers(managers);
                        Cache.setManagerDTO(managers);
                        initRecyclerView(managers);
                        managersSwipe.setRefreshing(false);

                        //Copy to db
                        RealmHelper helper = new RealmHelper(context);
                        helper.copyToRealmOrUpdate(managers);
                        Log.e("RealmCopy", "it's ok");
                    }
                });
    }