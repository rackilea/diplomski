MongoDatabase database = client.getDatabase("admin");    
Document document1 = database.runCommand(new Document("currentOp", 1)
        .append("active", true));
Document document2 = database.runCommand(new Document("currentOp", 1)
        .append("active", false));
Document document3 = database.runCommand(new Document("currentOp", 1)
        .append("active", true)
        .append("secs_running", new Document("$gt", 3)));