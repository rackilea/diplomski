public List<DBObject> getResultsInDescendingOrderByDate(int limit) {

        List<DBObject> myList = null;
        DBCursor myCursor=myCollection.find().sort(new BasicDBObject("date",-1)).limit(10);
        myList = myCursor.toArray();

        return myList;
    }