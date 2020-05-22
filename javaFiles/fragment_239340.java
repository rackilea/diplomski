public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

    private List<DateTimeFormatter> availableFormatters = new ArrayList<>();

    protected LocalDateDeserializer() {
        super(LocalDate.class);
        availableFormatters.add(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        availableFormatters.add(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) 
            throws IOException {

        String value = p.getText();

        if (value == null) {
            return null;
        }

        for (DateTimeFormatter formatter : availableFormatters) {
            try {
                return LocalDate.parse(value, formatter);
            } catch (DateTimeParseException e) {
                // Safe to ignore
            }
        }

        throw ctxt.weirdStringException(value, LocalDate.class, "Unknown date format");
    }
}