public static BookBuilder tagBuilder(String type, String name, String id, String author) {
     return tagBuilder(type, name)
            .status(STATUS)
            .addTag(ID, id)
            .addTag(AUTHOR, author);
}

public static BookBuilder tagBuilder(String type, String name) {
    return Book.builder()
            .type(type)
            .name(name);
}