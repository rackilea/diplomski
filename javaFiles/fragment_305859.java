final List<Item> items = new ArrayList<>();
    Realm realm = null;
    try {
         realm = Realm.getInstance(new RealmConfiguration.Builder(context).build());

        final RealmQuery<Checkboxes> queryCheck = realm.where(Checkboxes.class);
        final RealmQuery<ImageItem> queryImage = realm.where(ImageItem.class);

        RealmResults<Checkboxes> checkBoxes = queryCheck.findAll();
        RealmResults<ImageItem> imageItems = queryImage.findAll();

        for(Checkboxes checkbox : checkBoxes) {
            items.add(realm.copyFromRealm(checkbox));
        }
        for(ImageItem checkbox : checkBoxes) {
            items.add(realm.copyFromRealm(checkbox));
        }
    } finally {
        if(realm != null) {
            realm.close();
        }
    }
    return Observable.just(items);