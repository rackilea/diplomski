mIndicatorTable.sync()
        .flatMap(new Function<Boolean, SingleSource<MobileServiceList<IndicatorModel>>>() {
            @Override
            public SingleSource<MobileServiceList<IndicatorModel>> apply(Boolean aBoolean) throws Exception {
                return mIndicatorTable.table().read(null);
            }
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(...)