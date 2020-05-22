import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;

@JsonTypeInfo(
          use = JsonTypeInfo.Id.CLASS, 
          include = JsonTypeInfo.As.PROPERTY, 
          property = "type")
public interface Vehicle {
}