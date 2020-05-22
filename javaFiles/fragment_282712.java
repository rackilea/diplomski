import com.fasterxml.jackson.databind.ObjectMapper;

ObjectMapper mapper = new ObjectMapper();
Map<String, String> testMap = new HashMap<String, String>(); 
testMap .put("1", "abc"); 
testMap .put("2", "ezc"); 
testMap .put("3", "afc"); 
testMap .put("4", "cvc"); 

      mapper.writeValue(new File("c:\\user.json"), testMap);