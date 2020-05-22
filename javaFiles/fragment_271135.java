class CsvEntityGenerator {

    private final CsvMapper mapper;
    private final CsvSchema schema;

    public CsvEntityGenerator(Class clazz) {
        mapper = new CsvMapper();
        mapper.enable(CsvGenerator.Feature.STRICT_CHECK_FOR_QUOTING);

        schema = mapper.schemaFor(clazz).withNullValue("");
    }

    public String toCsvString(Object entity) throws IOException {
        return mapper.writer(schema).writeValueAsString(entity);
    }
}