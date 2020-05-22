//tell to jackson where to find the type name
@JsonTypeInfo(   use = JsonTypeInfo.Id.NAME, include = As.PROPERTY, property = "type")
// tell to jackson the implementations to scan
@JsonSubTypes({
    @JsonSubTypes.Type(value = InputFieldDto.class, name = "input")
    //, ...
})
public class AbstractFieldDto {
}

//tell to jackson what is the type name in json
@JsonTypeName("input")
public class InputFieldDto extends AbstractFieldDto {

    private String fieldType = FieldType.INPUT.name();
    private String text;
}