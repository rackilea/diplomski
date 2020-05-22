public class EmailConverter extends StdConverter<String, String> {
    @Override
    public String convert(final String value) {
        return Optional.ofNullable(value)
                .filter(email -> email.length() > 0)
                .filter(email -> email.contains("@"))
                .orElse(null);
    }
}