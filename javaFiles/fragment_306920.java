@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ChildOne.class, name = "childOne"),
        @JsonSubTypes.Type(value = ChildTwo.class, name = "childTwo")})
public class BaseClass {
    private Integer id;
}