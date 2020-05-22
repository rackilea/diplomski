public class CustomSerializer extends StdSerializer<Map> {
    protected CustomSerializer() {
        super(Map.class);
    }

    @Override
    public void serialize(Map map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeStartObject();
        for (Object key : map.keySet()) {
            if(!"key3".equals(key)){
                jsonGenerator.writeStringField((String) key, (String) map.get(key));
            }
        }
        jsonGenerator.writeStringField("key4","value4");
        jsonGenerator.writeEndObject();
    }
}

public class Main {

    public static void main(String[] args) throws Exception{

        Map<String, String> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");

        ObjectMapper mapper = new ObjectMapper();
        SimpleModule serializerModule = new SimpleModule("SerializerModule", new Version(1, 0, 0, null, "mt", "customSerializerTest"));
        serializerModule.addSerializer(new CustomSerializer());
        mapper.registerModule(serializerModule);

        System.out.println(mapper.writeValueAsString(map));
    }
}

Output:
{"key1":"value1","key2":"value2","key4":"value4"}