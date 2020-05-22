@Converter
public class DataEnumConverter implements AttributeConverter<DataEnum, String> {
    @Override
    public String convertToDatabaseColumn(DataEnum enum) {
       // Convert your enum to DB value
    }

    @Override
    public DataEnum convertToEntityAttribute(String dbValue) {

       // Convert String to your enum
    }
}