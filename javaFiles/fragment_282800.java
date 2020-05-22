import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainClass {

    public static void main(String[] args) throws JsonProcessingException {     

        Content content = new Content();
        content.setTitle("title");
        content.setDescription("description");

        ResultsBlock result = new ResultsBlock ();
        result.setContent(content);
        result.setType("result");

        //  JSONObject(result);
        ObjectMapper mapper = new ObjectMapper(); 

        String jsonString = mapper.writeValueAsString(result);

        System.out.println(jsonString);
    }


}