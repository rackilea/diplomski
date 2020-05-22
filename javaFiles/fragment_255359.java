public static final Version luceneVersion = Version.LUCENE_40;

IndexWriter getIndexWriter(){

    Directory indexDir = FSDirectory.open(new File( INDEX_PATH ));

    IndexWriterConfig luceneConfig = new IndexWriterConfig(
                luceneVersion, new StandardAnalyzer(luceneVersion));

    return(new IndexWriter(indexDir, luceneConfig));
   }