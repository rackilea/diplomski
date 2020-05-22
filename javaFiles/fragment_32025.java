public class JacksonSchema1 {
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface Example {
        String value();
    }

    public static class MyPojo {
        @Example("Bob")
        public String name;

        @Example("42")
        public Integer myInt;

        public String noExample;
    }

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        MyJsonFormatVisitorWrapper visitor = new MyJsonFormatVisitorWrapper(mapper);
        mapper.acceptJsonFormatVisitor(MyPojo.class, visitor);
        System.out.println(mapper.writeValueAsString(visitor.getExample()));
    }

    private static class MyJsonFormatVisitorWrapper implements JsonFormatVisitorWrapper {
        private final ObjectMapper mapper;
        private final Map<String, Object> example = new LinkedHashMap<>();

        private MyJsonFormatVisitorWrapper(ObjectMapper mapper) {
            this.mapper = mapper;
        }

        @Override
        public JsonObjectFormatVisitor expectObjectFormat(JavaType type) throws JsonMappingException {
            return new JsonObjectFormatVisitor.Base() {
                @Override
                public void optionalProperty(BeanProperty prop) throws JsonMappingException {
                    Example a = prop.getAnnotation(Example.class);
                    if (a != null) {
                        example.put(prop.getName(), mapper.convertValue(a.value(), prop.getType()));
                    } else {
                        example.put(prop.getName(), prop.getType().toCanonical());
                    }
                }
            };
        }

        @Override
        public JsonArrayFormatVisitor expectArrayFormat(JavaType type) throws JsonMappingException {
            return null;
        }

        @Override
        public JsonStringFormatVisitor expectStringFormat(JavaType type) throws JsonMappingException {
            return null;
        }

        @Override
        public JsonNumberFormatVisitor expectNumberFormat(JavaType type) throws JsonMappingException {
            return null;
        }

        @Override
        public JsonIntegerFormatVisitor expectIntegerFormat(JavaType type) throws JsonMappingException {
            return null;
        }

        @Override
        public JsonBooleanFormatVisitor expectBooleanFormat(JavaType type) throws JsonMappingException {
            return null;
        }

        @Override
        public JsonNullFormatVisitor expectNullFormat(JavaType type) throws JsonMappingException {
            return null;
        }

        @Override
        public JsonAnyFormatVisitor expectAnyFormat(JavaType type) throws JsonMappingException {
            return null;
        }

        @Override
        public JsonMapFormatVisitor expectMapFormat(JavaType type) throws JsonMappingException {
            return null;
        }

        @Override
        public SerializerProvider getProvider() {
            return null;
        }

        @Override
        public void setProvider(SerializerProvider provider) {

        }

        public Map<String,Object> getExample() {
            return example;
        }
    }
}