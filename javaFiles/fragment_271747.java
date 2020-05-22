public class AuthorDeserializer implements JsonDeserializer<Author> {
    @Override
    public Author deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonObject authorObject = json.getAsJsonObject();

        Author author = new Author();
        author.name = authorObject.get("name").getAsString();

        Type booksListType = new TypeToken<List<Book>>(){}.getType();
        author.books = context.deserialize(authorObject.get("books"), booksListType);

        for(Book book : author.books) {
            book.author = author;
        }

        return author;
    }   
}