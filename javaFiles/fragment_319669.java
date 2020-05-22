Mongo mongo = new Mongo("localhost", 27017);
DB db = mongo.getDB("data base name");
CommandResult resultSet = db.getCollection("collectionName").getStats();
System.out.println(resultSet);
System.out.println(resultSet.get("count"));
System.out.println(resultSet.get("avgObjSize"))