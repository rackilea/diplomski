class MyObject extends RealmObject {

    RealmList<MySubObject> subObjects;
}

...

myObject.subObjects.where().findAll(); //returns a RealmResults

//you can query your list like
myObject.subObjects
     .where()
     .equalTo("status", "done")
     .findAll(); //you can use sort, findFirst etc