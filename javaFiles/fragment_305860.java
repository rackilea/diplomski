private Subscription readFromEditText() {
    return RxTextView.textChanges(editText).switchMap(charSequence -> {
        String selectedName = charSequence.toString();
        RealmQuery<Dog> query = realm.where(Dog.class);
        if(selectedName != null && !"".equals(selectedName)) {
            query = query.contains(DogFields.NAME, selectedName, Case.INSENSITIVE);
        }
        return query.findAllSortedAsync(DogFields.NAME)
                    .asObservable();
    }).filter(RealmResults::isLoaded) //filter async realm query
      .subscribe(dogs -> adapter.updateData(dogs));
}