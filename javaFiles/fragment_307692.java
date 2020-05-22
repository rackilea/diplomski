public class JacksonDateFormat {
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface MyJsonFormat {
        String value();
    }

    public static class Bean {
        @MyJsonFormat("dd.MM.yyyy") @JsonSerialize(using = MyDateSerializer.class)
        public final Date date1;

        @MyJsonFormat("yyyy-MM-dd") @JsonSerialize(using = MyDateSerializer.class)
        public final Date date2;

        public Bean(final Date date1, final Date date2) {
            this.date1 = date1;
            this.date2 = date2;
        }
    }

    public static class MyDateSerializer extends JsonSerializer<Date>
            implements ContextualSerializer {
        private final String format;

        private MyDateSerializer(final String format) {this.format = format;}

        public MyDateSerializer() {this.format = null;}

        @Override
        public void serialize(
                final Date value, final JsonGenerator jgen, final SerializerProvider provider)
                throws IOException {
            jgen.writeString(new SimpleDateFormat(format).format(value));
        }

        @Override
        public JsonSerializer createContextual(
                final SerializationConfig serializationConfig, final BeanProperty beanProperty)
                throws JsonMappingException {
            final AnnotatedElement annotated = beanProperty.getMember().getAnnotated();
            return new MyDateSerializer(annotated.getAnnotation(MyJsonFormat.class).value());
        }
    }

    public static void main(String[] args) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final Bean value = new Bean(new Date(), new Date());
        System.out.println(mapper
                        .writerWithDefaultPrettyPrinter()
                        .writeValueAsString(value));
    }
}