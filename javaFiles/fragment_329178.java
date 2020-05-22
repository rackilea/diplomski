BasicDBList notifications = (BasicDBList) cursor.curr().get("Notification");

BasicDBObject first = (BasicDBObject) notifications.get(0); //first document
BasicDBObject second = (BasicDBObject) notifications.get(1); //second document
BasicDBObject third = (BasicDBObject) notifications.get(2); //third document

System.out.println(first.get("description")); // bbbbbbbbbbbbbbb
System.out.println(second.get("url")); // bbbbbbbbbbbbbb