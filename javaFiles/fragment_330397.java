import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonSubTypes({
    @JsonSubTypes.Type(value = Car.class, name = "car"),
    @JsonSubTypes.Type(value = Truck.class, name = "truck") }
)
@JsonTypeInfo(
          use = JsonTypeInfo.Id.NAME, 
          include = JsonTypeInfo.As.PROPERTY, 
          property = "type")
public interface Vehicle {
}