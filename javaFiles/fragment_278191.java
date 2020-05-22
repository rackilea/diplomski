public class Demo {

    static Directory dir;

    IndexWriter indexWriter;

    public boolean openIndex() {
        try {
            dir = new RAMDirectory();
            Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_44);
            IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_44, analyzer);
            indexWriter = new IndexWriter(dir, iwc);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void finish() {
        try {
            indexWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addDoc() {
        Document doc = new Document();
        doc.add(new TextField("field1", "val1", Field.Store.YES));
        doc.add(new TextField("field2", "val2", Field.Store.YES));
        doc.add(new TextField("field3", "val3", Field.Store.YES));
        doc.add(new TextField("field4", "val4", Field.Store.YES));

        try {
            indexWriter.addDocument(doc);
            indexWriter.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printResults(Query query) throws IOException {
        IndexReader reader = DirectoryReader.open(dir);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopDocs result = searcher.search(query, 5);
        System.out.println("# of results:" + result.totalHits);
        for (ScoreDoc doc : result.scoreDocs) {
            System.out.println(doc);
        }

        reader.close();
    }

    public static void main(String[] args) throws IOException, ParseException {
        Demo demo = new Demo();
        demo.openIndex();
        demo.addDoc();
        demo.finish();


        BooleanQuery booleanQuery = new BooleanQuery();
        Query query1 = new TermQuery(new Term("field1", "val1"));
        Query query2 = new TermQuery(new Term("field2", "val2"));
        Query query3 = new TermQuery(new Term("field3", "val3"));
        Query query4 = new TermQuery(new Term("field4", "val4"));
        booleanQuery.add(query1, BooleanClause.Occur.SHOULD);
        booleanQuery.add(query2, BooleanClause.Occur.SHOULD);
        booleanQuery.add(query3, BooleanClause.Occur.SHOULD);
        booleanQuery.add(query4, BooleanClause.Occur.SHOULD);
        printResults(booleanQuery);

        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_44);
        MultiFieldQueryParser multiQueryParser = new MultiFieldQueryParser(Version.LUCENE_44,
                    new String[] {"field1", "field2", "field3", "field4"}, analyzer);
        multiQueryParser.setDefaultOperator(QueryParser.Operator.OR);

        Query mfQuery = multiQueryParser.parse("field1:val1 field2:val2 field3:val3 field4:val4");
        printResults(mfQuery);

        Query mfQuery2 = multiQueryParser.parse("field1:val* field2:x field3:y field4:z");
        printResults(mfQuery2);

    }
}