public class Body { 

    private String value; 
    private boolean valueDefined;

    public void setValue(String value) {
        this.value = value;
        this.valueDefined = true;
    }

    public String getValue() {
        return value;
    }

    public boolean isValueDefined() {
        return valueDefined;
    }
}