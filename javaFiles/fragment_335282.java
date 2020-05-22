import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Map;

public class MapSerdes implements Serde<Map<String, String>> {

    private static final Charset CHARSET = Charset.forName("UTF-8");

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {}

    @Override
    public void close() {}

    @Override
    public Serializer<Map<String, String>> serializer() {
        return new Serializer<Map<String, String>>() {
            private Gson gson = new Gson();
            @Override
            public void configure(Map<String, ?> configs, boolean isKey) {}

            @Override
            public byte[] serialize(String topic, Map<String, String> data) {
                String line = gson.toJson(data); // Return the bytes from the String 'line'
                return line.getBytes(CHARSET);
            }

            @Override
            public void close() {}
        };
    }

    @Override
    public Deserializer<Map<String, String>> deserializer() {
        return new Deserializer<Map<String, String>>() {
            private Type type = new TypeToken<Map<String, String>>(){}.getType();
            private Gson gson = new Gson();
            @Override
            public void configure(Map<String, ?> configs, boolean isKey) {}

            @Override
            public Map<String, String> deserialize(String topic, byte[] data) {
                Map<String,String> result = gson.fromJson(new String(data), type);
                return result;
            }

            @Override
            public void close() {}
        };
    }
}