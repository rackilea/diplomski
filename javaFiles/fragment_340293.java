// Create a RealmConfiguration that saves the Realm file in the app's "files" directory. 
//(Recommended to add this code in your Application or first Activity)
 RealmConfiguration realmConfig = new RealmConfiguration.Builder(context).build();
 Realm.setDefaultConfiguration(realmConfig);

//then call it from your service
 Realm realm = Realm.getInstance(this);

 //access your realm object
 realm.beginTransaction();
 final Dog managedDog = realm.copyToRealm(dog); // Persist unmanaged objects
 Person person = realm.createObject(Person.class); // Create managed objects directly
 person.getDogs().add(managedDog);
 realm.commitTransaction();