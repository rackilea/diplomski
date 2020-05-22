// inside iterator
TopDocs docs;
if (lastScore == null) {
    docs = searcher.search(query, filter, limit, Sort.INDEXORDER, false, false);
} else {
    docs = searcher.searchAfter(lastScore, query, filter, limit, Sort.INDEXORDER, false, false);
}
lastScore = docs.scoreDocs[docs.scoreDocs.length - 1];
for (ScoreDoc scoreDoc : docs.scoreDocs) {
    Document = searcher.doc(scoreDoc.doc, fields));
}