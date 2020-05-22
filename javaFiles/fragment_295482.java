import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.io.IOException;
import java.util.List;

public class JsonProcessor { // This implementation can change as you want.

    public static <T> List<T> unmarshallToList(String json, Class<T> classType)
            throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        CollectionType javaType = mapper.getTypeFactory() // Check here whether you can take different function to directly de-serialize to the object than to a List.
                .constructCollectionType(List.class, classType);

        return mapper.readValue(json, javaType);
    }
}