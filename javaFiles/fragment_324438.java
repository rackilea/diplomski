public class DTO<T> {
    private Integer prettyFieldId;
    private Integer pages;
    private Integer total;

    @JsonAlias({"forms", "submissions"})
    private List<T> items;

    //getters, setters
}