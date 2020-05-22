BasicDBObject doc=new BasicDBObject();
BasicDBObject q=new BasicDBObject("group_name",selectedgn);
doc.put("Notification.date_from",frm);
doc.put("Notification.date_too",too);
doc.put("Notification.description",desc);
doc.put("Notification.url",url);
con.coll.update(q,new BasicDBObject("$set",doc));