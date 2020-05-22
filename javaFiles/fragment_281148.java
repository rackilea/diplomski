DBCursor dbCursor = datastore.getCollection(MyClass.class).find(query);
while (dbCursor.hasNext()) {
    DBObject obj = dbCursor.next();
    MyClass class = morphia.fromDBObject(datastore, MyClass.class, obj);
    // do stuff
}