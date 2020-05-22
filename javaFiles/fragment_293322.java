while (cursor.hasNext()) {
    BasicDBObject dbObject = (BasicDBObject) cursor.next();
    x.add(dbObject);
    // use dbObject to access the object
    // since the cursor has already been placed at the next position
}