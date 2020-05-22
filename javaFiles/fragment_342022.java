Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_CURRENT);

// Store the index in memory:
//Directory directory = new RAMDirectory();

Store an index on disk
Directory directory = FSDirectory.open(indexfilesDirPathOnYourServer);
IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_CURRENT, analyzer);
IndexWriter iwriter = new IndexWriter(directory, config);
Document doc = new Document();
String title = getTitle();
doc.add(new Field("fieldname", text, TextField.TYPE_STORED));
iwriter.addDocument(doc);
iwriter.close();