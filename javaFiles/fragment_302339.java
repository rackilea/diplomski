@JsonDeserialize(using = InstanceDeserializer.class)
public abstract class Instance {
    //.. methods
}

@JsonDeserialize(as = UserInstance.class)
public class UserInstance extends Instance {
    //.. methods
}

@JsonDeserialize(as = HardwareInstance.class)
public class HardwareInstance extends Instance {
    //.. methods
}

public class InstanceDeserializer extends JsonDeserializer<Instance> {
    @Override
    public Instance deserialize(JsonParser jp,  DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        ObjectNode root = (ObjectNode) mapper.readTree(jp);
        Class<? extends Instance> instanceClass = null;
        if(checkConditionsForUserInstance()) {
            instanceClass = UserInstance.class;
        } else { 
            instanceClass = HardwareInstance.class;
        }   
        if (instanceClass == null){
            return null;
        }
        return mapper.readValue(root, instanceClass );
    }
}