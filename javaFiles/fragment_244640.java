public class Explainer {

  public static void main(String[] args) throws Exception {

     if (args.length != 2) {
        System.err.println("Usage: Explainer <index dir> <query>");
        System.exit(1);
     }

     String indexDir = args[0];
     String queryExpression = args[1];
     Directory directory = FSDirectory.open(new File(indexDir));
     QueryParser parser = new QueryParser(Version.LUCENE_CURRENT,
                                     "contents", new SimpleAnalyzer());

     Query query = parser.parse(queryExpression);
     System.out.println("Query: " + queryExpression);
     IndexSearcher searcher = new IndexSearcher(directory);
     TopDocs topDocs = searcher.search(query, 10);
     for (int i = 0; i < topDocs.totalHits; i++) {
        ScoreDoc match = topDocs.scoreDocs[i];
        Explanation explanation = searcher.explain(query, match.doc);   
        System.out.println("----------");
        Document doc = searcher.doc(match.doc);
        System.out.println(doc.get("title"));
        System.out.println(explanation.toString());
     }
  }
}