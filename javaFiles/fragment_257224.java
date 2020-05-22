public CompletableFuture<String> pushDataToArray(String path, Map<String, Object> paramsToAdd) {
    final DatabaseReference databaseReference = getUserDataReference().child(path).push();
    paramsToAdd.put("createdAt", ServerValue.TIMESTAMP);

    return toCompletableFuture(databaseReference.setValueAsync(paramsToAdd), this.executionContext)
            .thenApply(voidResult -> databaseReference.getKey());
}