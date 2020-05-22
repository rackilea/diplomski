DBCursor cursor = collection.find();
    while (cursor.hasNext()) {
        BasicDBObject current_object = (BasicDBObject) cursor.next();

        current_object.update(
                new BasicDBObject().append("_id", current_object.getObjectId("_id"), 
                        new BasicDBObject()
                                .append(
                                        "$set", 
                                        new BasicDBObject("employeeID", Integer.parseInt(current_object.getString("employeeID"))
                                        )
                                )
                )
        );
    }