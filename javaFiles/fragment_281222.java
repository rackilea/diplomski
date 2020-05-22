@Converter
public class MyPojoToJsonConverter implements AttributeConverter<MyPojo, String>{

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(MyPojo myPojo) {
        String json = "";
        try {
            json = objectMapper.writeValueAsString(myPojo);
        } catch (JsonProcessingException jpe) {
            // Handle exception
        }
        return json;
    }

    @Override
    public MyPojo convertToEntityAttribute(String myPojoAsJson) {
        MyPojo myPojo = null;
        try {
            myPojo = objectMapper.readValue(myPojoAsJson, MyPojo.class);
        } catch (JsonParseException e) {
            // HandleException
        } catch (JsonMappingException e) {
            // HandleException
        } catch (IOException e) {
            // HandleException
        }
        return myPojo;
    }
}