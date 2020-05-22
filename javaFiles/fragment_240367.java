import java.io.IOException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Sample {

    public B fromJson(String jsonA) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonA, B.class);
    }

    public void doProcess(B b){
        b.setTemp_1("newTemp1");
        b.setName("newName");
    }
    public String toJson(B b) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(b);
    }

    public static void main(String[] args) 
       throws JsonParseException, JsonMappingException, IOException {

        String incomingJson = "{ \"id\": \"123\",  \"name\" : \"JM\" }";
        System.out.println("Input->  " + incomingJson);
        Sample sample = new Sample();
        B b = sample.fromJson(incomingJson);
        sample.doProcess(b);
        String modifiedJson = sample.toJson(b);
        System.out.println("Output-> "+modifiedJson);
    }
}