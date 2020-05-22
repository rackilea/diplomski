javaaddpath(pathToJarFile)

import com.mongodb.*;

mongoClient = MongoClient(mHost);
mongoConn = mongoClient.getDB(dbName);
auth = mongoConn.authenticate(user,password);

events = mongoConn.getCollection('events');

empty = BasicDBObject();
events.remove(empty);