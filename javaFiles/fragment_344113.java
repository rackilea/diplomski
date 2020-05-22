Mongo mongo = PowerMockito.mock(Mongo.class);
DB db = PowerMockito.mock(DB.class);
DBCollection dbCollection = PowerMockito.mock(DBCollection.class);

PowerMockito.when(mongo.getDB("foo")).thenReturn(db);
PowerMockito.when(db.getCollection("bar")).thenReturn(dbCollection);

MyService svc = new MyService(mongo); // Use some kind of dependency injection
svc.getObjectById(1);

PowerMockito.verify(dbCollection).findOne(new BasicDBObject("_id", 1));