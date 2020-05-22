DBCursor cursor = runSomeQuery();
try {
        while(cursor.hasNext()) {
            DBObject dbObject  = cursor.next();
            ObjectId id = (ObjectId) dbObject.get("_id");
            dbObject.removeField("_id");
            dbObject.put("ID", id.toString());
            System.out.println(dbObject);
        }

    }   finally {
        cursor.close();
    }