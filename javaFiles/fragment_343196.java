import java.util.UUID;

public class UuidConverter {
    public static UUID parse(String xmlValue) {
        return UUID.fromString(xmlValue);
    }

    public static String print(UUID value) {
        return value.toString();
    }
}