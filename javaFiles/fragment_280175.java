public int getTotalCoordinateCount(){

  BasicDbObject group = new BasicDBObject()
  .append("_id", 1)
  .append("count", new BasicDBObject("$sum", 1));

  BasicDbObject project= new BasicDBObject()
  .append("_id", 0)
  .append("count", 1);

   AggregationOutput output = db.getPeopleCollection().aggregate(Arrays. <DBObject>asList(
     new BasicDBObject("$unwind", "coords"),
     new BasicDBObject("$group", group),
     new BasicDBObject("$project", project)
   );

    BasicDbObject result = (BasicDBObject)output.results().iterator.next();

   return result.getInt("count");

}