public class JacksonTwoDeserilizers {

    public static class Bean {

        public final Date date;

        @JsonCreator
        public Bean(@JsonProperty("date") Date date) {
            this.date = date;
        }

        @Override
        public String toString() {
            return "Bean{" +
                    "date=" + date +
                    '}';
        }
    }

    public static class DateDeserializer extends StdDeserializer<Date> {

        private final int hours;

        protected DateDeserializer(int hours) {
            super(Date.class);
            this.hours = hours;
        }

        @Override
        public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            Date date = this._parseDate(jp, ctxt);
            return new Date(date.getTime() + 1000 * 60 * 60 * hours);
        }
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper1 = new ObjectMapper();
        ObjectMapper mapper2 = new ObjectMapper();
        SimpleModule module1 = new SimpleModule();
        SimpleModule module2 = new SimpleModule();
        module1.addDeserializer(Date.class, new DateDeserializer(6));
        mapper1.registerModule(module1);
        module2.addDeserializer(Date.class, new DateDeserializer(12));
        mapper2.registerModule(module2);

        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(new Date(currentTimeMillis));
        String json = "{\"date\":" + currentTimeMillis + "}";
        System.out.println("Mapper1: " + mapper1.readValue(json, Bean.class));
        System.out.println("Mapper2: " + mapper2.readValue(json, Bean.class));
    }
}