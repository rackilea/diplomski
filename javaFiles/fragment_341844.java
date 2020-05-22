public class JacksonProvider {
    public static class JacksonIncludeNullJsonProvider extends JacksonJaxbJsonProvider
    {
        public JacksonIncludeNullJsonProvider() {
            // must be the first call to initialize the mapper
            configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, false);
            _mapperConfig.getConfiguredMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        }

    }

    public static class Bean {
        @XmlElement(name = "xmlField1")
        public final String field1;
        public final String field2;
        public final String field3 = null;
        public final Map<String, Object> field4 = Collections.emptyMap();

        public Bean(String field1, String field2) {
            this.field1 = field1;
            this.field2 = field2;
        }
    }

    public static void main(String[] args) throws IOException {
        JacksonIncludeNullJsonProvider provider = new JacksonIncludeNullJsonProvider();
        JacksonJaxbJsonProvider provider2 = new JacksonJaxbJsonProvider();
        Bean bean = new Bean("a", "b");
        provider.writeTo(bean, Bean.class, null, null, MediaType.APPLICATION_JSON_TYPE, null, System.out);
        System.out.println();
        provider2.writeTo(bean, Bean.class, null, null, MediaType.APPLICATION_JSON_TYPE, null, System.out);
    }
}