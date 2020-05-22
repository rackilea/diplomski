import com.celoxity.protobuf.ExampleOuterClass.Example;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Timestamp;

import java.time.Instant;
import java.util.Map;

public class ProtobufApp {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = JsonMapper.builder()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .addMixIn(Example.class, ExampleMixin.class)
                .addMixIn(Timestamp.class, TimestampMixin.class)
                .build();

        String json = "{" +
                "\"json_id\":\"3\"," +
                "\"json_another_id\":\"43\"," +
                "\"code\":34," +
                "\"json_name\":\"Yeyproto\"," +
                "\"currTime\":{\"seconds\":1575909372,\"nanos\":35000000}" +
            "}";
        Example deserialised = mapper.readValue(json, Example.class);

        System.out.println(deserialised);
        Timestamp currTime = deserialised.getCurrTime();
        System.out.println(Instant.ofEpochSecond(currTime.getSeconds(), currTime.getNanos()));
    }
}

abstract class ExampleMixin extends ProtoBufIgnoredMethods {

    @JsonProperty("json_id")
    String id_;

    @JsonProperty("json_another_id")
    String anotherId_;

    @JsonProperty("code")
    int code_;

    @JsonProperty("json_name")
    String name_;

    @JsonProperty("currTime")
    Timestamp currTime_;
}

abstract class TimestampMixin extends ProtoBufIgnoredMethods {
    @JsonProperty("seconds")
    String seconds_;

    @JsonProperty("nanos")
    String nanos_;
}

abstract class ProtoBufIgnoredMethods {
    @JsonIgnore
    public abstract Map<Descriptors.FieldDescriptor, Object> getAllFields();
}