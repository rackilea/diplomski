class PojoJsonDeserializer extends JsonDeserializer<Pojo> {

    @Override
    public Pojo deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        InnerPojo innerPojo = jp.readValueAs(InnerPojo.class);

        return innerPojo.toPojo();
    }

    private static class InnerPojo {
        public List<String> key;
        public String value;

        Pojo toPojo() {
            Pojo pojo = new Pojo();
            pojo.setKey(new ArrayList<String>(key));
            pojo.setValue(valueNTimes(value, key.size()));

            return pojo;
        }

        private List<String> valueNTimes(String value, int nTimes) {
            List<String> result = new ArrayList<String>(nTimes);
            for (int index = 0; index < nTimes; index++) {
                result.add(value);
            }

            return result;
        }
    }
}