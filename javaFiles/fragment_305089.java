public long next(String collection) {
        CollectionSeq next = operations.findAndModify(
                query(where("collection").is(collection)),
                new Update().inc("current", 1),
                options().returnNew(true).upsert(true),
                CollectionSeq.class
        );
        return Objects.requireNonNull(next).getCurrent();
}