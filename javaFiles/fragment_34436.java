Index indexCache = null;

synchronized Index getIndex() {
    if (indexCache == null)
        indexCache = deserializeIndex();

    return indexCache;
}

Index deserializeIndex() {
    File indexFile = new File(indexFilePath());

    ....
}

List<Result> searchInIndex(Query query) {
    Index index = getIndex();

    List<Result> results = index.fetch(query);

    ....
}