RealmResults<MessageContentTable> messageContentTables;

public void something() {
    messageContentTables = realm.where(MessageContentTable.class).findAllAsync();
    messageContentTables.addChangeListener((collection, changeSet) -> {
        Log.e("Updating 123"+collection.size());
    });