class DTO {
String key1;
@JsonDeserialize(using = BooleanKeyDeserializer.class)
Object booleanKey;
//setters getters
}