BasicDBObject criteria = new BasicDBObject();                                       
criteria.put("syslog.device","10.10.20.2");

BasicDBObject elemMatchObj = new BasicDBObject();
elemMatchObj.put("$elemMatch", new BasicDBObject("device", "10.10.20.2"));

DBCursor cur = coll.find(criteria, new BasicDBObject("syslog", elemMatchObj));
while(cur.hasNext() && !isStopped()) {
    String json = cur.next().toString(); 
}//end of while