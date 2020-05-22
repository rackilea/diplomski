import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyClass {

private String name;

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

@JsonProperty("customMethod")
public String customMethod() {
    return "test";
}

public static void main(String[] args) {

    ObjectMapper objectMapper = new ObjectMapper();

    MyClass test = new MyClass();
    test.setName("myName");

    try {
        System.out.println(objectMapper.writeValueAsString(test));
    } catch (JsonProcessingException e) {
        e.printStackTrace();
    }

}
}