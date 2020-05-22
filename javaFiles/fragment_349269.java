import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class User {

    private int fooId;
    private String name;
    private int age;

    public int getFooId() {
        return fooId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public User(@JsonProperty("age") Integer age, @JsonProperty("name") String name,
                @JsonProperty("foo") JsonNode foo) {
        this.age = age;
        this.name = name;
        this.fooId = foo.path("id").asInt();
    }

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();

        String json = "{\"foo\":{\"id\":1}, \"name\":\"Albert\", \"age\": 32}" ;
        try {
            User user = objectMapper.readValue(json, User.class);

            System.out.print("User fooId: " + user.getFooId());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}