byte[] key = new byte[64];
new SecureRandom().nextBytes(key);
RealmConfiguration config = new RealmConfiguration.Builder(context)
  .encryptionKey(key)
  .build();

Realm realm = Realm.getInstance(config);