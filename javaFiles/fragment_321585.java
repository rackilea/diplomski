public static void main(String[] args) {

    IndexingFileHandler indexHandler = new IndexingFileHandler();

    List<FileHandler> handlers = new LinkedList<FileHandler>();
    handlers.add(new PigLatinFileHandler());
    handlers.add(indexHandler);
    handlers.add(new SimilarToPigLatinFileHandler());

    FileHandlerManager.processFile(file, handlers);

    // Note now you have a reference to indexHandler; so if you wanted to save
    // any state while processing the words you can, and use it here.
}