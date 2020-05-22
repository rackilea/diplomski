IndexReader reader = IndexReader.open(...);
IndexWriter writer = new IndexWriter(...);

for(int i = 0; i < reader.maxDoc(); i++) {
    if(reader.isDeleted(i)) continue;
    Document d = reader.document(i);
    Document d2 = new Document();
    for(Field f : (List<Field>)d.getFields()) {
        Field f2 = f;
        if(f.name().equals(FIELD_NAME))
            f2 = new Field(FIELD_NAME, f.stringValue(), Field.Store.YES, Field.Index.NOT_ANALYZED);
        d2.add(f2);
    }
    writer.addDocument(d2);
}

writer.optimize();
writer.close();