@Post
public void methodName(final T entity) {
    .
    .
    .
    result.use(Results.json()).withoutRoot().from(insertedObject).serialize();
}