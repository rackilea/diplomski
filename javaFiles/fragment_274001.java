@Override
protected void onDestroy() {
    super.onDestroy();
    try (Realm realm = Realm.getDefaultInstance()) {
        realm.removeAllChangeListeners();
    }
}