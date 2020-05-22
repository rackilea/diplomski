@SqlResultSetMapping(
        name = "AuthorMapping",
        entities = @EntityResult(
                entityClass = Author.class,
                fields = {
                    @FieldResult(name = "id", column = "authorId"),
                    @FieldResult(name = "firstName", column = "firstName"),
                    @FieldResult(name = "lastName", column = "lastName"),
                    @FieldResult(name = "version", column = "version")}))