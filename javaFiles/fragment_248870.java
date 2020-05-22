public enum AssesmentType {
PERCENTAGE("1"),PERCENTILE("2");
private String value;

private static final Map<String, AssesmentType stringMap 
        = new HashMap<String, AssesmentType ();

static {
    for (AssesmentType  b : AssesmentType .values()) {
        stringMap.put(b.getValue(),b);          
    }
}

AssesmentType(String value){
  this.value = value;
}

public String getValue() {
    return value;
}

public AssesmentType fromString(String value) {
    return stringMap.get(value);
}

}