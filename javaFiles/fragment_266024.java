DBObject next = cursor.next();
BasicDBList listEditions = (BasicDBList)next.get("listEditions");
for(Object element: listEditions) {
    BasicDBList listInsertions = (BasicDBList)((BasicDBObject)element).get("listInsertion");
    for(Object lie: listInsertions) {
        System.out.println(lie);
        //System.out.println(((BasicDBObject)lie).get("fromDate"));
    }
}