DBCursor cursor = students.find();
    while (cursor.hasNext()) {
        final DBObject student = cursor.next();
        BasicDBList courses = (BasicDBList) student.get("courses");
        for (Object course : courses) {
            ((BasicDBObject) course).append("modules", "moduleID");
        }
        students.update(
                        new BasicDBObject("id","test"), //update query
                        new BasicDBObject("$set", new BasicDBObject("courses", courses))
        );
    }