int getDocumentsCount() {
  try {
    Closer closer = Closer.create();
    try {
       IndexWriter iwriter = closer.register(openIndexWriter());
      return iwriter.numDocs();
    } catch (Throwable e) {
      closer.rethrow(e);
    } finally {
      closer.close();
    }
  } catch (IOException e) {
    logger.error(e, e);
    return -1;
  }
}