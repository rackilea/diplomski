BasicDBObject gtquery = new BasicDBObject("number", 
    new BasicDBObject("$gt", 3).append("$lt", 5)
);

DBCursor cur = col.find(gtquery);
try {
    while (cur.hasNext()) {
        System.out.println(cur.next());
    }
} finally {
    cur.close();
}