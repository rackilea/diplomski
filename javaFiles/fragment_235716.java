datastore.put(post);    
Entity comment = new Entity("comment", post.getKey());
comment.setProperty("content", commentContent);
comment.setProperty("time", timeStamps);
DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
datastore.put(comment);