private final Handler handler = new Handler(Looper.getMainLooper());

private RealmResults<Member> objectResults;
private RealmChangeListener<RealmResults<Member>> objectTracker = (results) -> {
    if(member != null && member.isValid()) {
        return;
    }
    if(realm.isInTransaction()) {
        handler.post(() -> {
            setupMember(results);
        });
    } else {
        setupMember(results);
    }
};

private void setupMember(RealmResults<Member> members) {
    if(member != null && member.isValid()) {
        member.removeAllChangeListeners();
    }
    member = members.first(null);
    if(member != null) {
        member.addChangeListener((member, fieldChangeSet) -> {
            // do whatever
        }); 
    }
}

private Member member;

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
    if(member != null) {
        member.removeAllChangeListeners();
    }
    objectResults.removeAllChangeListeners();
    realm.close();
}