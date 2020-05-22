import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
public class InstantDeserializer extends StdDeserializer<Instant> {

public InstantDeserializer() {
    this(null); 
} 

public InstantDeserializer(Class<?> vc) {
    super(vc); 
}

private SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD'T'hh:mm:ss.SSS'Z'");

@Override
public Instant deserialize(JsonParser jp, DeserializationContext ctxt)
  throws IOException, JsonProcessingException {
    JsonNode node = jp.getCodec().readTree(jp);
    Date date = null;
    try {
        date = sdf.parse(node.asText());
    } catch (Exception e) {
        throw new MyException("Instant field deserialization failed");
    }
    return date.toInstant();
}
}