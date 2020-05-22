private static void addDoc(IndexWriter writer, String content) throws IOException {
    FieldType fieldType = new FieldType();
    fieldType.setStoreTermVectors(true);
    fieldType.setStoreTermVectorPositions(true);
    fieldType.setIndexed(true);
    fieldType.setIndexOptions(IndexOptions.DOCS_AND_FREQS);
    fieldType.setStored(true);
    Document doc = new Document();
    doc.add(new Field("content", content, fieldType));
    writer.addDocument(doc);
}

public static void main(String[] args) throws IOException, ParseException {
    Directory directory = new RAMDirectory();  
    Analyzer analyzer = new WhitespaceAnalyzer(Version.LUCENE_40);
    IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_40, analyzer);
    IndexWriter writer = new IndexWriter(directory, config);
    addDoc(writer, "bla bla bla bleu bleu");
    addDoc(writer, "bla bla bla bla");
    writer.close();
    DirectoryReader reader = DirectoryReader.open(directory);
    DocsEnum de = MultiFields.getTermDocsEnum(reader, MultiFields.getLiveDocs(reader), "content", new BytesRef("bla"));
    int doc;
    while((doc = de.nextDoc()) != DocsEnum.NO_MORE_DOCS) {
          System.out.println(de.freq());
    }
    reader.close();
}