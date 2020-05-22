@JsonRootName("authors") // This is new compared to your example
public class Response {
    private final List<Author> authors;

    @JsonCreator
    public Response(@JsonProperty("author") final List<Author> authors) {
        this.authors = authors;
    }

    @JsonProperty("author")
    public List<Author> getAuthors() {
        return authors;
    }
}