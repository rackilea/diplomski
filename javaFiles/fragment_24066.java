Realm realm = Realm.getInstance(context);
realm.beginTransaction();
realm.clear(SomeClass.class);
realm.clear(AnotherClass.class);
realm.commitTransaction();
realm.close();