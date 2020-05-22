private void initRealm() {
    Realm.init(this);
    RealmConfiguration configuration = new RealmConfiguration.Builder()
            .schemaVersion(3)
            .name("sipradi")
            .migration(new RealmMigrationClass())
            .build();
    Realm.setDefaultConfiguration(configuration);
}

private class RealmMigrationClass implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();
        if (oldVersion == 2) {
            RealmObjectSchema profileUserSchema = schema.get("ProfileUser");
            profileUserSchema.addField("test", String.class);

            // Delete all other data than `ProfileUser`
            for (RealmObjectSchema classSchema : schema.getAll()) {
                if (classSchema.getClassName().equals("ProfileUser")) {
                    continue;
                }
                realm.delete(classSchema.getClassName());
            }
            oldVersion++;
        }
    }
}