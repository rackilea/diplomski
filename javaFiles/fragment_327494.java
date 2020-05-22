BasicDBObject query1;
DBCursor cursor;
query1 = new BasicDBObject("age", new BasicDBObject("$gt", 25));
cursor = incollection.find(query1);
while(cursor.hasNext()){
     System.out.println(cursor.next().get("username"));
}