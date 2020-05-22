while (cursorEvents.hasNext()) {
    DBObject documentInEventCollection = cursorEvents.next();

    System.out.println(documentInEventCollection.get("type").toString());

    if ("pageLoad".equals(documentInEventCollection.get("type"))) {

        System.out.println(documentInEventCollection.get("url").toString());
    } else {

        System.out.println(documentInEventCollection.get("type").toString());             
   }