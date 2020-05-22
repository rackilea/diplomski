import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

    @JsonProperty("aLogId")
    private String aLogId;

    public void setaLogId(String aLogId) {
        this.aLogId = aLogId;
    }

    public String getaLogId() {
        return aLogId;
    }

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();

        Test test = new Test();

        test.setaLogId("anId");

        try {
            System.out.println("Serialization test: " + objectMapper.writeValueAsString(test));


            String json = "{\"aLogId\":\"anotherId\"}";

            Test anotherTest = objectMapper.readValue(json, Test.class);

            System.out.println("Deserialization test: " +anotherTest.getaLogId());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}