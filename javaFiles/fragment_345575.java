public class JacksonIgnoreByType {
    public static final String JSON = "{\n" +
            "  \"bean1\" : {\n" +
            "    \"field1\" : \"value1\"\n" +
            "  },\n" +
            "  \"bean2\" : {\n" +
            "    \"field2\" : \"value2\"\n" +
            "  },\n" +
            "  \"bean3\" : {\n" +
            "    \"field3\" : \"value3\"\n" +
            "  }\n" +
            "}\n";

    public static class Bean1 {
        public String field1;

        @Override
        public String toString() {
            return "Bean1{" +
                    "field1='" + field1 + '\'' +
                    '}';
        }
    }

    @JsonIgnoreType
    public static class Bean2 {
        public String field2;
    }

    public static class Bean3 {
        public String field3;
    }

    public static class Bean4 {
        public Bean1 bean1;
        public Bean2 bean2;
        public Bean3 bean3;

        @Override
        public String toString() {
            return "Bean4{" +
                    "bean1=" + bean1 +
                    ", bean2=" + bean2 +
                    ", bean3=" + bean3 +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector(){
            @Override
            public boolean hasIgnoreMarker(AnnotatedMember m) {
                return m.getRawType() == Bean3.class || super.hasIgnoreMarker(m);
            }
        });

        System.out.println(mapper.readValue(JSON, Bean4.class));
    }
}