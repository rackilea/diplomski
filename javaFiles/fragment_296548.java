DBObject clause1 = new BasicDBObject("post_title", regex);  
DBObject clause2 = new BasicDBObject("post_description", regex);    
BasicDBList or = new BasicDBList();
or.add(clause1);
or.add(clause2);
DBObject query = new BasicDBObject("$or", or);