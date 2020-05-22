/**** Get database ****/
        // if database doesn't exists, MongoDB will create it for you
        MongoDatabase mydatabase = mongoClient.getDatabase("mydatabase");

        /**** Get collection / table from 'testdb' ****/
        // if collection doesn't exists, MongoDB will create it for you

        FindIterable<Document> mydatabaserecords = mydatabase.getCollection("collectionName").find();
        MongoCursor<Document> iterator = mydatabaserecords.iterator();
        while (iterator.hasNext()) {
            Document doc = iterator.next();
            // do something with document
        }