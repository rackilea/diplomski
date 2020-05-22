@Data
public class GRT{

    @Expose @SerializedName("queries")
    private List<QueryWrapper> queries = new ArrayList<>();

    public List<Query> getQueries() {
        return queries.stream().map(it->it.query).collect(Collectors.toList());
    }

    @Expose @SerializedName("executeQuery")
    List<String> executeQuery = new ArrayList<>();
}
@Data
public class QueryWrapper {
    @Expose @SerializedName("query")
    Query query;
}
@Data
public class Query {
    public
    @Expose @SerializedName("id")
    String id;

    @Expose @SerializedName("description")
    String description;
}