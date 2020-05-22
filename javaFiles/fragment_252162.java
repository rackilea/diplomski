@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class MyList extends ArrayList<Integer> {
    private final Integer id;
    private final String title;

    @JsonCreator
    public MyList(@JsonProperty("id") final Integer id,
                  @JsonProperty("title") final String title,
                  @JsonProperty("items") final List<Integer> items) {
        super(items);
        this.id = id;
        this.title = title;
    }

    @JsonProperty("id")
    public Integer id() {
        return id;
    }

    @JsonProperty("items")
    public Integer[] items() {
        return this.toArray(new Integer[size()]);
    }

    @JsonProperty("title")
    public String title() {
        return title;
    }
}