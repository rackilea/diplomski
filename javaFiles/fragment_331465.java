@Converter
public class GradeConverter implements AttributeConverter<Grade, String> {

    private ObjectMapper objectMapper;

    public GradeConverter() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Jdk8Module());
    }

    @Override
    public String convertToDatabaseColumn(Grade grade) {

        if (grade == null) {
            return null;
        }

        return objectMapper.writeValueAsString(grade);
    }

    @Override
    public Grade convertToEntityAttribute(String s) {

        if (s == null) {
            return null;
        }

        return objectMapper.readValue(s, Grade.class);
    }
}