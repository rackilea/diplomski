public List<Document> performLuceneSearch(final Query query) throws IOException {
  // the reader instance is reused as often as possible, and exchanged
  // when a write occurs using DirectoryReader.openIfChanged(...).
  final AllDocumentsCollector collector = new AllDocumentsCollector(this.reader.numDocs());
  this.searcher.search(query, collector);
  return collector.getDocuments();
}