Directory directory = null;
    IndexWriter writer = null;
    try {
        directory = FSDirectory.open(new File(args[0]));
        IndexWriterConfig iwConf = new IndexWriterConfig(Version.LUCENE_48,
                new KeywordAnalyzer());
        iwConf.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        writer = new IndexWriter(directory, iwConf);
        Document document = new Document();
        document.add(new StringField("title", "Cat", Store.YES));
        writer.addDocument(document);
        writer.commit();
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }