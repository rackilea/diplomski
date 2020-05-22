public class JacksonFinalTest {

    private static final class MyClass {

        @JsonProperty("myProperty")
        public final String myProperty = "myPropertyValueInit";
    }

    private static final class MyClass2 {

        @JsonProperty("myProperty")
        public final String myProperty;

        public MyClass2() {
            myProperty = "myPropertyValueInit";
        }
    }

    @Test
    public void doTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, JsonParseException, JsonMappingException, IOException {

        final String json = "{\"myProperty\":\"myPropertyValueDeserialized\"}";
        final MyClass2 deserializedMyClass1 = new ObjectMapper().readValue(json, MyClass2.class);

        // "myPropertyValueInit"
        final String directValue = deserializedMyClass1.myProperty;

        // "myPropertyValueDeserialized"
        final String reflectValue = (String) MyClass2.class.getDeclaredField("myProperty").get(deserializedMyClass1);

        assertEquals(directValue, reflectValue);

    }
}