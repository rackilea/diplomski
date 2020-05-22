Observable<List<<Sth>> results;
Subscription subscription;
Action1<List<Sth>> changeListener = (element) -> {
    if(element.isLoaded()) {
        adapter.updateData(element);
    }
};

void sth() {
    results = realm.where(Sth.class).findAllSortedAsync("id").asObservable();
    subscription = results.subscribe(changeListener);
}

void unsth() {
    if(subscription != null && !subscription.isUnsubscribed()) {
        subscription.unsubscribe();
        subscription = null; 
        results = null;
    }
}