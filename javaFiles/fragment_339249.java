public class StackHelper {
String code, selling, buying, median, value;

public StackHelper() {
}

public String getCode() {
    return code;
}

public void setCode(String code) {
    this.code = code;
}

public String getSelling() {
    return selling;
}

public void setSelling(String selling) {
    this.selling = selling;
}

public String getBuying() {
    return buying;
}

public void setBuying(String buying) {
    this.buying = buying;
}

public String getMedian() {
    return median;
}

public void setMedian(String median) {
    this.median = median;
}

public String getValue() {
    return value;
}

public void setValue(String value) {
    this.value = value;
}

@Override
public String toString () {
    return code;
}}