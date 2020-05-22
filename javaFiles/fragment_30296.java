private void matchResponse(Store store) {

}

private Observable<Store> performOperation(Event event) {
    if (event == null) {
        return Observable.empty();
    }
    return xyz.getValue(event).toObservable().map((value) -> new Store(event, value));
}