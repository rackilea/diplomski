public class JacksonHide {
    @JsonIgnoreProperties("hidden")
    public static interface IHideable {
        boolean isHidden();
    }

    public static class Address implements IHideable {
        public final String city;
        public final String street;
        public final boolean hidden;

        public Address(String city, String street, boolean hidden) {
            this.city = city;
            this.street = street;
            this.hidden = hidden;
        }

        @Override
        public boolean isHidden() {
            return hidden;
        }
    }

    public static class PersonalInfo implements IHideable {
        public final String name;
        public final int age;
        public final boolean hidden;

        public PersonalInfo(String name, int age, boolean hidden) {
            this.name = name;
            this.age = age;
            this.hidden = hidden;
        }

        @Override
        public boolean isHidden() {
            return hidden;
        }
    }

    private static class MyBeanSerializerModifier extends BeanSerializerModifier {
        @Override
        public JsonSerializer<?> modifySerializer(SerializationConfig config,
                                                  BeanDescription beanDesc,
                                                  JsonSerializer<?> serializer) {
            if (IHideable.class.isAssignableFrom(beanDesc.getBeanClass())) {
                return new MyIHideableJsonSerializer((JsonSerializer<IHideable>) serializer);
            }
            return super.modifySerializer(config, beanDesc, serializer);
        }

        private static class MyIHideableJsonSerializer extends JsonSerializer<IHideable> {
            private final JsonSerializer<IHideable> serializer;

            public MyIHideableJsonSerializer(JsonSerializer<IHideable> serializer) {
                this.serializer = serializer;
            }

            @Override
            public void serialize(IHideable value,
                                  JsonGenerator jgen,
                                  SerializerProvider provider) throws IOException {
                if (!value.isHidden()) {
                     serializer.serialize(value, jgen, provider);
                }

            }
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.setSerializerModifier(new MyBeanSerializerModifier());
        mapper.registerModule(module);

        PersonalInfo p1 = new PersonalInfo("John", 30, false);
        PersonalInfo p2 = new PersonalInfo("Ivan", 20, true);
        Address a1 = new Address("A", "B", false);
        Address a2 = new Address("C", "D", true);

        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString
                (Arrays.asList(p1, p2, a1, a2)));
    }

}