Realm.deleteRealmFile(this);
Realm realm = Realm.getInstance(this);
File realmFile = new File(this.getFilesDir(), "default.realm");

long tic = System.currentTimeMillis();
for (int i = 0; i < 25; i++) {
    for (int j = 0; j < 100; j++) {
        realm.beginTransaction();
        TestObject testObject = realm.createObject(TestObject.class);
        testObject.setApprovedBy("Approver_" + j);
        testObject.setAuthor("Author_" + j);
        testObject.setBannedBy("Banner_" + j);
        testObject.setClicked(j % 2 == 0);
        testObject.setCommentCount(j);
        testObject.setCreated(System.currentTimeMillis());
        testObject.setCreatedUTC(j*7);
        testObject.setEdited(j % 3 == 0);
        realm.commitTransaction();
    }
    realm.beginTransaction();
    realm.where(TestObject.class).findAll().clear();
    realm.commitTransaction();
    Log.i(TAG, "Size: " + realmFile.length());
}
long toc = System.currentTimeMillis();
Log.i(TAG, "Time: " + (toc - tic));