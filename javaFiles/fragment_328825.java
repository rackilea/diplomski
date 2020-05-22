import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.PROPERTY, property = "type"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Coke.class, name = "coke"),
    @JsonSubTypes.Type(value = Sprite.class, name = "sprite")
})
public abstract class Item {

   // no changes

}