protected DBObject getMappedKeyword(Keyword keyword, MongoPersistentEntity<?> entity) {
    ...
    if (keyword.isSample()) {
        return exampleMapper.getMappedExample(keyword.<Example<?>> getValue(), entity);
    }
    ...
}

public boolean isSample() {
    return "$sample".equalsIgnoreCase(key);
}