int getDocumentsCount() {
  try {
    return doGetDocumentsCount();
  } catch (IOException e) {
    logger.error(e, e);
    return -1;
  }
}

int doGetDocumentsCount() throws IOException {
  Closer closer = Closer.create();
  try {
    IndexWriter iwriter = closer.register(openIndexWriter());
    return iwriter.numDocs();
  } catch (Throwable e) {
    closer.rethrow(e);
  } finally {
    closer.close();
  }
}