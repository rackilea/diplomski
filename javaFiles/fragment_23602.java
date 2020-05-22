public class JsonTest {
    public static void main(String[] args) throws JsonProcessingException {
    ObjectMapper mapper=new ObjectMapper();
    Map<String,String> dt=new Hashtable();
    dt.put("1", "welcome");
    dt.put("2", "bye");
    String jsonString = mapper.writeValueAsString(dt)
    System.out.println(jsonString);
    }    
}