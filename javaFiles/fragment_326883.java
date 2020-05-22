RealmConfiguration realmConfiguration1 = new RealmConfiguration.Builder(this)
                                                               .name("realmName1")
                                                               .build();   
RealmConfiguration realmConfiguration2 = new RealmConfiguration.Builder(this)
                                                               .name("realmName2")
                                                               .build();

Realm realm1 = Realm.getInstance(realmConfiguration1);
/* do your operations in realm1 */
Realm realm2 = Realm.getInstance(realmConfiguration2);
/* do your operations in realm2 */