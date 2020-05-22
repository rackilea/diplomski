return source.publish(o -> {
    PublishSubject<Object> ps = PublishSubject.create();
    return o.buffer(() -> ps)
            .mergeWith(Observable.defer(() -> {
                o.filter(bufferClosingCriteria).subscribe(ps);
                return Observable.empty();
            }))
            .filter(list -> !list.isEmpty());
});