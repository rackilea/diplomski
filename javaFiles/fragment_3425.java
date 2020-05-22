import java.util.Collection;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = DtoDeserializer.class)
public class Dto {
    String type;
    Collection<Config> configs;
}