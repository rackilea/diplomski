public class Entity {
    public String name;
    @JsonDeserialize(using = EntityValueDeserializer.class)
    public Object value;
    public Class valueType;
}