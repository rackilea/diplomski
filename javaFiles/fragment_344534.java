@JsonDeserialize(as = OneFilter.class)
public class OneFilter implements Filter, Serializable {
    private String type;
    private String field1;
    private int field2;
    @JsonCreator
    public OneFilter(@JsonProperty("type") String type, @JsonProperty("field1") String field1, @JsonProperty("field2") int field2) {
        // omit
    }
    // getter and setter
    // override toString
}

@JsonDeserialize(as = AnotherFilter.class)
public class AnotherFilter implements Filter, Serializable {
    private String type;
    private List<Integer> field3;
    private double field4;
    @JsonCreator
    public AnotherFilter(@JsonProperty("type") String type, @JsonProperty("field3") List<Integer> field3, @JsonProperty("field4") double field4) {
        // omit
    }
    // getter and setter
    // override toString
}