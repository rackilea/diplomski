TopDocs hits = indexSearcher.search(...);
for (ScoreDoc scoreDoc : hits.scoreDocs) {
   Document doc = indexSearcher.doc(scoreDoc.doc);
   if (...) {
      indexSearcher.getIndexReader().deleteDocument(doc);
   }
}