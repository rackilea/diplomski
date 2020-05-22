private RealmResults<Member> objectResults;
private RealmChangeListener<RealmResults<Member>> objectTracker = (results) -> {
    setupMember(results);
};

private void setupMember(RealmResults<Member> members) {
    Member member = members.first(null);
    if(member != null) {
        updateViews(member); // update views with member
    } else {
        // member doesn't exist or was deleted
    }
}

private Realm realm;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(...);
    realm = Realm.getDefaultInstance();
    objectResults = realm.where(Member.class).equalTo("name", name).findAllAsync();
    objectResults.addChangeListener(objectTracker);
}

@Override
protected void onDestroy() {
    super.onDestroy();
    objectResults.removeAllChangeListeners();
    realm.close();
}