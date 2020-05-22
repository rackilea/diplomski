Document doc=new Document();
//Note, changed these field names.
doc.add(new Field("title", event.getTitle(), Field.Store.YES, Field.Index.ANALYZED));
doc.add(new Field("place", event.getPlace(), Field.Store.YES, Field.Index.ANALYZED));
doc.add(new Field("description", event.getDescription(), Field.Store.YES, Field.Index.ANALYZED));
doc.add(new Field("table", yourTableName, Field.Store.YES, Field.Index.NO));