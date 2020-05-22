Observable.zip(
    service.loadPopCells().toObservable(),
    service.loadChallangeData().toObservable(),
    service.loadUserCell().toObservable(),
    Arrays::asList)
    .subscribe(this::sendtoViewmodel);