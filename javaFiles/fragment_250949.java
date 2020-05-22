MongoCursor<Document> cur = col.find(new BasicDBObject("hData._id", new BasicDBObject("$ne",null))).iterator();

    while(cur.hasNext()){
        Document doc = cur.next();
        System.out.println("Document _id" + doc.get("_id"));
        Document hdata = doc.get("hData", Document.class);
        Object id = hdata.get("_id");
        System.out.println("hData._id " + id);

        // check type if you need to
        if (id instanceof String) {
            System.out.println("hData._id is String: " + id);
        } else if (id instanceof ObjectId) {
            System.out.println("hData._id is ObjectId: " + id);
        } else {
            System.out.println("hData._id is of type " + id.getClass().getName());
        }
    }