Observable<Model> oi = ...;
oi.groupBy(model -> model.key)
    .flatMapSingle(Observable::toList)
    .subscribe(modelsGrouped -> { // key: modelsGrouped.get(0).key
        double avg = average(modelsGrouped);
        //...
    });