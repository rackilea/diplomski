@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = A.class, name = "A"),
        @JsonSubTypes.Type(value = B.class, name = "B")})
public interface MyInterface {

}