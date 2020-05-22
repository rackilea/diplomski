public class dbRealm extends RealmObject{
    @PrimaryKey
    private String id; // null is a valid id and we will use it here

    private RealmList<Long> points; // Realm 4.0.0+

    public RealmList<Long> getPoints() {
        return points;
    }
}

Realm.setDefaultConfiguration(new RealmConfiguration.Builder()
         .initialData((realm) -> {
             realm.createObject(dbRealm.class, null);
         })
         .deleteIfMigrationNeeded() // todo: make sure you can have this
         .build();