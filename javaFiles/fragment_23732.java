import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Map;
import org.postgresql.util.HStoreConverter;

@Converter
public class MyHStoreConverter implements AttributeConverter<Map<String, String>, String> {
    @Override
    public String convertToDatabaseColumn(Map<String, String> attribute) {
        return HStoreConverter.toString(attribute);
    }

    @Override
    public Map<String, String> convertToEntityAttribute(String dbData) {
        return HStoreConverter.fromString(dbData);
    }
}