BasicDBObject doc=new BasicDBObject();
BasicDBObject q=new BasicDBObject("group_name",selectedgn);
doc.put("date_from",frm);
doc.put("date_too",too);
doc.put("description",desc);
doc.put("url",url);
BasicDBObject doc1=new BasicDBObject();
doc1.put("Notification",doc);
con.coll.update(q,new BasicDBObject("$set",doc1));