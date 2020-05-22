public class JsonUserSerializer extends JsonSerializer<User> {
        @Override
        public void serialize(User o, JsonGenerator jsonGen, SerializerProvider serializerProvider)
                throws IOException, JsonProcessingException {
            // ... logic of json generation
            Field[] userClassFields = o.getClass().getDeclaredFields();
            // ... logic of json generation
        }

        @Override
        public Class<User> handledType() {
            return User.class;
        }
    }