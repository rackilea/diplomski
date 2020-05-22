RealmResults<Sth> results;
RealmChangeListener<RealmResults<Sth>> changeListener = (element) -> {
    if(element.isLoaded()) {
        adapter.updateData(element);
    }
};

void sth() {
    results = realm.where(Sth.class).findAllSortedAsync("id");
    results.addChangeListener(changeListener);
}

void unsth() {
    if(results != null && results.isValid()) {
        results.removeChangeListener(changeListener);
        results = null;
    }
}