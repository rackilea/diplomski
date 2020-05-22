// Because "Criteria" has a bug when invoking its method "elemMatch", 
// so I build the criteria by the driver directly, almost.  

DBObject c1 = new BasicDBObject("occupied", null);
DBObject c2 = BasicDBObjectBuilder.start().push("occupied").push("$not").
                        push("$elemMatch").add("$gte", start).add("$lte", end).get();
Criteria c = where("$or").is(Arrays.asList(c1, c2));
Query query = new Query().addCriteria(c);
List<Room> rooms = mongoTemplate.find(query, Room.class);