Class SomeClassOriginal {
    private String stringValue; 
    private List<String> collectionValue = new ArrayList<>();
    private JsonNode jsonStringValue;
    private boolean booleanValue;

    //general getters and setters
}

Class SomeClass {
    private String stringValue; 
    private List<String> collectionValue = new ArrayList<>();
    private String jsonStringValue;
    private boolean booleanValue;

    public SomeClass(SomeClassOriginal someClassOriginal) {
        super();
        this.stringValue = someClassOriginal.stringValue;
        this.collectionValue = someClassOriginal.collectionValue ;
        this.jsonStringValue= someClassOriginal.jsonStringValue.toString();
        this.booleanValue= someClassOriginal.booleanValue;
    }

    //general getters and setters
}