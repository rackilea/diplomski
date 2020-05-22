DirectoryReader ireader = DirectoryReader.open(indexfilesDirPathOnYourServer);
IndexSearcher isearcher = new IndexSearcher(ireader);
// Parse a simple query that searches for "text":
QueryParser parser = new QueryParser(Version.LUCENE_CURRENT, "fieldname", analyzer);//note here we used the same analyzer object
Query query = parser.parse("test");//test is am example for a search query
ScoreDoc[] hits = isearcher.search(query, null, 1000).scoreDocs;
// Iterate through the results:
for (int i = 0; i < hits.length; i++) {
  Document hitDoc = isearcher.doc(hits[i].doc);
  System.out.println(hitDoc.get("fieldname"));
}
ireader.close();
directory.close();