public class JsonPojo {
@JsonInclude(Include.NON_DEFAULT)
private int intVal;
@JsonProperty
private String strVal;

public int getIntVal() {
    return intVal;
}

public void setIntVal(int intVal) {
    this.intVal = intVal;
}

public String getStrVal() {
    return strVal;
}

public void setStrVal(String strVal) {
    this.strVal = strVal;
}}