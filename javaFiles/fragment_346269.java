Observable.zip(
        service.loadPopCells().toObservable(),
        service.loadChallangeData().toObservable(),
        service.loadUserCell().toObservable(),
        (data1, data2, data3) -> Arrays.asList(data1, data2, data3))
        .subscribe(dataList -> sendtoViewmodel(dataList));
    }