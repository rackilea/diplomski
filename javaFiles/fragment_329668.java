public class Migration implements RealmMigration {
    @Override
    public void migrate(final DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();
        if(oldVersion == 0) {
            RealmObjectSchema wordSchema = schema.get("Word");
            wordSchema.addField("nameLength", long.class, FieldAttribute.INDEXED, FieldAttribute.REQUIRED)
                      .transform(new RealmObjectSchema.Function() {
                          @Override
                          public void apply(DynamicRealmObject obj) {
                              obj.set("nameLength", obj.getString("name").length());
                          }
                      });
            oldVersion++;
        }
    }

    @Override
    public void equals(Object object) {
        return object != null && object instanceof Migration;
    }

    @Override
    public int hashCode() {
        return Migration.class.hashCode();
    }
}

RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(context)
                                             .schemaVersion(1)
                                             .migration(new Migration())
                                             .build();