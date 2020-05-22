BasicDBObject basicDBObject = new BasicDBObject();
    basicDBObject.put("company", "stackoverflow");
    basicDBObject.append("established", "when I started coding");
    basicDBObject.append("employees", Arrays.<DBObject>asList(
        new BasicDBObject("firstName", "john")
            .append("lastName", "doe"),
        new BasicDBObject("firstName", "anna")
            .append("lastName", "smith"),
        new BasicDBObject("firstName", "peter")
            .append("lastName", "jones")
    ));
    System.out.println(basicDBObject.toString());