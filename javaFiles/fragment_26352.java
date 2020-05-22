BulkWriteOperation bulk = coll.initializeOrderedBulkOperation();
    Integer count = 0;

    DBCursor cursor = coll.find(new BasicDBObject("projectid", "projectA"));

    while (cursor.hasNext()) {
        DBObject curRecord = cursor.next();
        curRecord.removeField("_id");  // why bother with a clone when you can remove the _id
        curRecord.put("projectid","projectB"); // replace the projectid
        bulk.insert(curRecord);
        count++;

        if ( count % 1000 == 0 ) {
            bulk.execute();
            bulk = collection.initializeOrderedBulkOperation();
        }
    }

    if (count % 1000 != 0 )
        bulk.execute();