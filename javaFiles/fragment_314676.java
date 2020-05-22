public class MyObjectConverter implements DynamoDBTypeConverter<String, List<MyObject>> {

    @Override
    public String convert(List<Object> objects) {
        //Jackson object mapper
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String objectsString = objectMapper.writeValueAsString(objects);
            return objectsString;
        } catch (JsonProcessingException e) {
            //do something
        }
        return null;
    }

    @Override
    public List<Object> unconvert(String objectssString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Object> objects = objectMapper.readValue(objectsString, new TypeReference<List<Object>>(){});
            return objects;
        } catch (JsonParseException e) {
            //do something
        } catch (JsonMappingException e) {
            //do something
        } catch (IOException e) {
            //do something
        }
        return null;
    }
}