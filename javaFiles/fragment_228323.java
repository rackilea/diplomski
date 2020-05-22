enum OperatorType {
    IS_ONE_OF("IS_ONE_OF", 1,
           Collections.singletonList(1)),
    IS_NOT_ONE_OF("IS_NOT_ONE_OF", 2,
           Collections.singletonList(1)),
    ENDS_WITH("ENDS_WITH", 3,
           Collections.singletonList(2)),
    DOES_NOT_ENDS_WITH("DOES_NOT_ENDS_WITH", 4,
           Collections.singletonList(2)),
    STARTS_WITH("STARTS_WITH", 5,
           Collections.singletonList(2)),
    DOES_NOT_START_WITH("DOES_NOT_START_WITH", 6,
           Collections.singletonList(2)),
    MATCHES("MATCHES", 7,
           Collections.singletonList(2)),
    DOES_NOT_MATCH("DOES_NOT_MATCH", 8,
           Collections.singletonList(2)),
    CONTAINS("CONTAINS", 9,
           Collections.singletonList(2)),
    DOES_NOT_CONTAIN("DOES_NOT_CONTAIN", 10,
           Collections.singletonList(2)),
    GREATER_THAN("GREATER_THAN", 11, Arrays.asList(3,4)), 
    GREATER_THAN_OR_EQUAL_TO("GREATER_THAN_OR_EQUAL_TO", 12, Arrays.asList(3,4)), 
    LESS_THAN("LESS_THAN", 13, Arrays.asList(3,4)),
    LESS_THAN_OR_EQUAL_TO("LESS_THAN_OR_EQUAL_TO", 15, Arrays.asList(3,4)), 
    AFTER("AFTER", 15,
           Collections.singletonList(5)),
    BEFORE("BEFORE", 16,
           Collections.singletonList(5));

    private final int value;

    private final String key;

    private final List<Integer> supportedtypes;

    OperatorType(String key, int value, List<Integer> supportedtypes) {
       this.value = value;
       this.key = key;
       this.supportedtypes = supportedtypes;
    }

    public int getValue() {
       return this.value;
    }

    public String getKey() {
       return this.key;
    }

    public List<Integer> getSupportedtypes() {
       return this.supportedtypes;
    }

    @Override
    public String toString() {
       return String.valueOf(this.value);
    }
}