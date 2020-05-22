IndexOptions options = new IndexOptions();

    // ensure the index is unique
    options.unique(true);
    // define the index
    dbColl.createIndex(new BasicDBObject("guid", 1), options);

    // add data to DB
    for (Object item : itemsArr) {

        // if there is a duplicate, skip it and write to a console (optionally)
        try {
            dbColl.insertOne(Document.parse(item.toString()));
        } catch (com.mongodb.MongoWriteException ex) {
            //System.err.println(ex.getMessage());
        }
    }